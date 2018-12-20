package com.burbank.recruit.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class RecruitmentApprovalController {

    @RequestMapping(method = RequestMethod.POST, value = "intiateRequestApproval", consumes = "application/json")
    public void emailRequest(@RequestBody String jsonForm ) throws IOException, MessagingException {

        sendmail(jsonForm);


    }


    private void sendmail(String jsonForm) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dwpshahzad@gmail.com", "dwp12345");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chaithra.ramachandran@working-age.digital.dwp.gov.uk"));
        msg.setSubject("Recruitment Request Approval");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Please approve attached request by clicking on (link here)", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.setText(jsonForm, "UTF-8", "plain");
        attachPart.addHeader("Content-Type", "application/json; charset=UTF-8");

        attachPart.setFileName("request.txt");
        multipart.addBodyPart(attachPart);

        msg.setContent(multipart);
        Transport.send(msg);
    }

}
