
/**
 * Send EMail using Java mail API to User(s) with attachment(s).
 *
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.java_Mail_API;

import static com.appium.constants.FrameworkConstants.TRUE;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailAttachmentsSender {

	/**
	 * i) Send n no. of Attachments
	 * 
	 * ii) Format set for TC count
	 * 
	 * iii) Send mail to n no. of Users
	 * 
	 */
	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String[] toAddress, String subject, String message, String... attachFiles)
			throws AddressException, MessagingException {

		Properties properties = new Properties(); 		// sets SMTP server properties
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", TRUE);
		properties.put("mail.smtp.starttls.enable", TRUE);
		properties.put("mail.user", userName);
		properties.put("mail.password", password);
		Authenticator auth = new Authenticator() { 		// creates a new session with an authenticator

			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		Message msg = new MimeMessage(session); 		// creates a new e-mail message


		msg.setFrom(new InternetAddress(userName));

		InternetAddress[] addressTo = new InternetAddress[toAddress.length];
		for (int i = 0; i < toAddress.length; i++)
			addressTo[i] = new InternetAddress(toAddress[i]);
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		/*
		 * InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		 * msg.setRecipients(Message.RecipientType.TO, toAddresses);
		 */
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		MimeBodyPart messageBodyPart = new MimeBodyPart(); 		// creates message part

		messageBodyPart.setContent(message, "text/html");

		Multipart multipart = new MimeMultipart(); // creates multi-part
		multipart.addBodyPart(messageBodyPart);

		if (attachFiles != null && attachFiles.length > 0) { // adds attachments

			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				multipart.addBodyPart(attachPart);
			}
		}
		msg.setContent(multipart);		// sets the multi-part as e-mail's content
		Transport.send(msg); 		// sends the e-mail

	}

}
