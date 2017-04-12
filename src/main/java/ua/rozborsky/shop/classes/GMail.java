package ua.rozborsky.shop.classes;

/**
 * Created by roman on 13.04.2017.
 */
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.interfaces.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class GMail implements Mail{
    public void send(String eMail, String link) {

        final String ADRESS = "rozborsky.test.page@gmail.com";//todo properties
        final String PASSWORD = "spongebobsquarepants";
        String SUBJECT = "carParts.ua";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ADRESS, PASSWORD);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eMail));
            message.setSubject(SUBJECT);
            message.setText(setMessage(link));
            Transport.send(message);
        } catch (MessagingException e) {
            //todo log4j
        }
    }


    private static String setMessage(String link) {//todo properties
        return "Доброго дня, ця поштова адреса була вказана при реєстрації на сайті CarParts.ua. " +
                "Для підтвердження реєстрації перейдіть, будь-ласка за посиланням:\n\n" +
                link +
                "\n\nТермін дії посиланя - 48 годин";
    }
}
