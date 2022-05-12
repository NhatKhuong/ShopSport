package com.se.util;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Mail {
	public static String sendEmail(String to,String sub, String body ) throws Exception {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("shopsportiuh@gmail.com");
        mailSender.setPassword("ShopSport2022");

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.transport.protocol", "smtp");     
        javaMailProperties.setProperty("mail.host", "smtp.gmail.com");  
        javaMailProperties.put("mail.smtp.auth", "true");  
        javaMailProperties.put("mail.smtp.port", "465");  
        javaMailProperties.put("mail.debug", "true");  
        javaMailProperties.put("mail.smtp.socketFactory.port", "465");  
        javaMailProperties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        javaMailProperties.put("mail.smtp.socketFactory.fallback", "false");  

        mailSender.setJavaMailProperties(javaMailProperties);
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

                message.setTo(to);
                message.setFrom(mailSender.getUsername());
                message.setSubject(sub);
                message.setBcc(mailSender.getUsername());
                message.setText(body, true);
            }
            
        };
        mailSender.send(preparator);

        return "Mail Sent Successfully.";
    }
}
