package com.tpfinal.service;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {


    public static void sendEmail(String to)
    {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("service.dutymap", "jonikarinico");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s.maximilianno@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Recupera tu clave de Dutymap");
            message.setText("Hola"
                    + "\n\n Recupera tu clave");

            Transport.send(message);

            System.out.println("Done");

        }

        catch (MessagingException e)
        {
            // throw new RuntimeException(e);
            System.out.println("Username or Password are incorrect ... exiting !");
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        String to = "s.maximilianno@gmail.com";
        sendEmail(to);
    }
}