package com.serviceImpl;
import com.dao.EmailVerificationDao;
import com.model.EmailVerification;
import com.service.EmailService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {
    EmailVerificationDao emailVerificationDao;

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @Override
    public boolean sendMail(String email) {
        return false;
    }


    @Override
    public boolean saveVerificationString(String str, String email) {
        EmailVerification emailVerification = new EmailVerification() ;
        emailVerification.setEmail(email);
        System.out.println(" email"+ emailVerification.getEmail());
        emailVerification.setVerificationString(str);
        System.out.println("str "+emailVerification.getVerificationString());
        System.out.println("emailverifiaction "+emailVerification);
        if(emailVerificationDao.saveVerificationString(emailVerification))
        {
            System.out.println(" In email service save verification method");
            return true;
        }
        else{
            return false;
        }
    }
}
    /*
    public void sendMail(String email)

    String msg = "<html>" + "<head>" + "</head>" + "<body>" +
            "Hi " +
            ",<br><br>You are Invited To subscribe following Topic." + topic + "<br><br>Please Follow the link to Subscribe the topic<b></b><br>" +
            "<a href='http://localhost:8080/'>Click Here to Register First</a><br><br>Thanks<br>LinkSharing" +
            "</body>" + "</html>";
    String recipientAddress = email;
    String subject = "Invitation";
    mailSender.send(new MimeMessagePreparator() {
        public void prepare(MimeMessage mimeMessage) throws MessagingException {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom("linksharing17@gmail.com");
            message.setTo(email);
            message.setSubject(subject);
            message.setText(msg, true);
            messageUser = "Email Sent";
        }
    });
}

}*/

