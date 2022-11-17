package dev.ososuna.email.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dev.ososuna.email.configuration.PropertiesConfig;
import dev.ososuna.email.model.EmailDetails;

@Service
public class EmailService {

  private final JavaMailSender javaMailSender;
  private final PropertiesConfig propertiesConfig;

  public EmailService(JavaMailSender javaMailSender, PropertiesConfig propertiesConfig) {
    this.javaMailSender = javaMailSender;
    this.propertiesConfig = propertiesConfig;
  }

  public String sendSimpleMail(EmailDetails details) {
    try {
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setFrom(propertiesConfig.getMailUsername());
      mailMessage.setTo(details.getRecipient());
      mailMessage.setText(details.getMsgBody());
      mailMessage.setSubject(details.getSubject());
      javaMailSender.send(mailMessage);
      return "Mail Sent Successfully...";
    } catch (Exception e) {
      return "Error while Sending Mail";
    }
  }  
}
