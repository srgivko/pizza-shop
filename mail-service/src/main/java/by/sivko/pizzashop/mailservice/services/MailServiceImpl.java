package by.sivko.pizzashop.mailservice.services;

import by.sivko.pizzashop.mailservice.entities.EMail;
import by.sivko.pizzashop.mailservice.repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender mailSender;
    private final MailRepository mailRepository;

    @Autowired
    public MailServiceImpl(JavaMailSender emailSender, MailRepository mailRepository) {
        this.mailSender = emailSender;
        this.mailRepository = mailRepository;
    }

    @Transactional
    @Override
    public void sendSimpleMessage(EMail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(mail.getSendTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        this.mailSender.send(message);
        mail.setSentAt(new Date());
        this.mailRepository.save(mail);
    }
}
