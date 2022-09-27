package com.app.email_Utils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EMailSender {
  @Autowired
  private JavaMailSender emailSender;
  
  @Value("${com.raktkosh.ORIGINS}")
  private String origin;

  public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
  }

  public void sendVerificationEmail(String to, String token) throws MessagingException {
   // String url = origin+"/verify/"+token;
    MimeMessage helper = emailSender.createMimeMessage();
    MimeMessageHelper template = new MimeMessageHelper(helper, true);
    template.setTo(to);
    template.setSubject("Raktkosh Account Verification");
    StringBuilder message = new StringBuilder("<h1>Order Placed confirmation mail from FreshCard </h1>");
  //  message.append("<p style='crimson'>An account has been created using this email address <b>" + to + "</b></p>");
  //  message.append("<p>If the request has been made by you, follow the link to verify.</p>");
  //  message.append("<p><a href='"+url+"'>"+url+"</a></p>");
 //   message.append("<p><b>You can simply ignnore this, if you've not requested.<b></p>");
    template.setText(message.toString(), true);
    emailSender.send(helper);
  }
}
