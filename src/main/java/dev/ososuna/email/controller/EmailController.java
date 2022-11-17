package dev.ososuna.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ososuna.email.model.EmailDetails;
import dev.ososuna.email.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping
  @CrossOrigin(origins = "*")
  public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetails) {
    return new ResponseEntity<>(emailService.sendSimpleMail(emailDetails), HttpStatus.OK);
  }
}
