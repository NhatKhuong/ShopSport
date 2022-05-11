package com.se.util;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Mail {
//	public static String sendEmail() throws Exception {
//
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        mailSender.setHost("your host");
//        mailSender.setPort(587);
//        mailSender.setUsername("Your email");
//        mailSender.setPassword("password");
//
//        Properties javaMailProperties = new Properties();
//        javaMailProperties.put("mail.smtp.starttls.enable", "false");
//        javaMailProperties.put("mail.smtp.auth", "true");
//        javaMailProperties.put("mail.transport.protocol", "smtp");
//        javaMailProperties.put("mail.debug", "true");
//
//        mailSender.setJavaMailProperties(javaMailProperties);
//        MimeMessagePreparator preparator = new MimeMessagePreparator() {
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//                message.setTo("To");
//                message.setFrom(mailSender.getUsername());
//                message.setSubject("Subject");
//                message.setBcc(mailSender.getUsername());
//                message.setText("Body", true);
//            }
//        };
//        mailSender.send(preparator);
//
//        return "Mail Sent Successfully.";
//    }
}
