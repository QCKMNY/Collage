package Controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Alex on 02.02.2017.
 */
public abstract class EmailController {
        static final String ENCODING = "UTF-8";
    final static String fromEmail = "simleemailconfimation@gmail.com"; //requires valid gmail id
    final static String password = "zse4xdr5cft6"; // correct password for gmail id

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    /**
     Outgoing Mail (SMTP) Server
     requires TLS or SSL: smtp.gmail.com (use authentication)
     Use Authentication: Yes
     Port for TLS/STARTTLS: 587
     */
    public static void sendConfirmation(String toEmail,String uniqueEmailCode) {
       System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        String url="http://localhost:8081/confirm?UUID="+uniqueEmailCode;
        String subject="Registration on Just Registration Service";
        String body ="\nThank you for registering!\n\nTo complete the registration process, verify your email address " +
                "by clicking this link: "+url+" \nSincerely,\nJust Registration Service Team";
        System.out.println("Session created");
        sendEmail(session, toEmail,subject,body );

    }
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("registrationservice.com", "Email Authentication"));

            msg.setReplyTo(InternetAddress.parse("registrationservice.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

