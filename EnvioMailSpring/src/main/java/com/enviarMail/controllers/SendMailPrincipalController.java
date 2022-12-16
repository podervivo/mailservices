package com.enviarMail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailPrincipalController {

    @Autowired
    protected JavaMailSender mail;
         
    @PostMapping("/SendMail")

   public ResponseEntity<?>  enviar_correo(){
    
     SimpleMailMessage email= new SimpleMailMessage();
    
            email.setTo("fernando.savoy@arba.gov.ar");
            email.setFrom("emiliano.garello@arba.gov.ar");
            email.setSubject("mail de prueba");
            email.setText("llego?");
          
            mail.send(email);
            
    return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
