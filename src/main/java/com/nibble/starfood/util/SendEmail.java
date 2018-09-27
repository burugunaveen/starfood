package com.nibble.starfood.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void mailSending(String emailAddress,String subject,String emailBody) {

	    final String username = "orders.starfood@gmail.com";
		final String password = "starfood123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("Starfood<orders.starfood@gmail.com>"));//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailAddress));
			message.setSubject(subject);
			message.setText(emailBody);
			

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
