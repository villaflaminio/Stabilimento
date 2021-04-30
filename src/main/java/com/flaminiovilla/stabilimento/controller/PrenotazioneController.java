package com.flaminiovilla.stabilimento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

   @GetMapping("/testUser")
   public ResponseEntity<String> user() {
      return ResponseEntity.ok("UTENTE");
   }
   @GetMapping("/testAdmin")
   public ResponseEntity<String> admin() {
      return ResponseEntity.ok("ADMIN");
   }

}
