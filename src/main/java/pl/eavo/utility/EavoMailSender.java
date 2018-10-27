package pl.eavo.utility;

import org.springframework.stereotype.Service;
import pl.eavo.model.Email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EavoMailSender {

    private Email email;

    public EavoMailSender(Email email){
        this.email = email;
    }

    public void sendMail() {
        final String username = "eavo.pl@gmail.com";
        final String password = "babilon354";

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
            message.setFrom(new InternetAddress("eavo.pl@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getRecipients().get(0)));
            message.setSubject(email.getTopic());
            message.setText(email.getMessage());

            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (
                MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
