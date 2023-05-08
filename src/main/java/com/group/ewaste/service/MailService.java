package com.group.ewaste.service;

import com.group.ewaste.domain.MailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendMailer;

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public void checkMail(MailRequest mailRequest) {
        Assert.notNull(mailRequest,"Mail request can not be empty");
        Assert.notNull(mailRequest.getSendTo(), "Mail recipient can not be empty");
        Assert.notNull(mailRequest.getSubject(), "Subject can not be empty");
        Assert.notNull(mailRequest.getText(), "Text can not be empty");
    }


    public void sendSimpleMail(MailRequest mailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        checkMail(mailRequest);
        message.setFrom(sendMailer);
        message.setTo(mailRequest.getSendTo().split(","));
        message.setSubject(mailRequest.getSubject());
        message.setText(mailRequest.getText());

        javaMailSender.send(message);
        logger.info("success:{}->{}",sendMailer,mailRequest.getSendTo());
    }

    public void sendHtmlMail(MailRequest mailRequest) {
        MimeMessage message = javaMailSender.createMimeMessage();
        checkMail(mailRequest);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(sendMailer);
            helper.setTo(mailRequest.getSendTo().split(","));
            helper.setSubject(mailRequest.getSubject());
            helper.setText(mailRequest.getText(),true);

            String filePath = System.getProperty("user.dir") + "/src/main/resources/file" + "/" + mailRequest.getSendTo()+ ".zip";
            if (StringUtils.hasText(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
//                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                String fileName = "data.zip";
                helper.addAttachment(fileName,file);
            }
            javaMailSender.send(message);
            logger.info("success:{}->{}",sendMailer,mailRequest.getSendTo());
        } catch (MessagingException e) {
            logger.error("error！",e);
        }
    }

    public void sendHtmlMailVoucher(MailRequest mailRequest) {
        MimeMessage message = javaMailSender.createMimeMessage();
        checkMail(mailRequest);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(sendMailer);
            helper.setTo(mailRequest.getSendTo().split(","));
            helper.setSubject(mailRequest.getSubject());
            helper.setText(mailRequest.getText(),true);

            String filePath = System.getProperty("user.dir") + "/voucher.png";
            if (StringUtils.hasText(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
//                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                String fileName = "voucher.png";
                helper.addAttachment(fileName,file);
            }
            javaMailSender.send(message);
            logger.info("success:{}->{}",sendMailer,mailRequest.getSendTo());
        } catch (MessagingException e) {
            logger.error("error！",e);
        }
    }

}
