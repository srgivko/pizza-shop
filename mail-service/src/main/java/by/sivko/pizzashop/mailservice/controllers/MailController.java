package by.sivko.pizzashop.mailservice.controllers;

import by.sivko.pizzashop.mailservice.entities.EMail;
import by.sivko.pizzashop.mailservice.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/email")
    public ResponseEntity<EMail> sendEmail(@RequestBody @Valid EMail mail) {
        this.mailService.sendSimpleMessage(mail);
        return ResponseEntity.ok(mail);
    }
}
