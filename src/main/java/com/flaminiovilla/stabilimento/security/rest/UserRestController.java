package com.flaminiovilla.stabilimento.security.rest;

import com.flaminiovilla.stabilimento.security.helper.UserHelper;
import com.flaminiovilla.stabilimento.security.model.User;
import com.flaminiovilla.stabilimento.security.rest.dto.LoginDTO;
import com.flaminiovilla.stabilimento.security.rest.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

   @Autowired
   UserHelper userHelper;

   @PostMapping("/authenticate")
   public ResponseEntity<UserHelper.JWTToken> authorize(@Valid @RequestBody LoginDTO loginDto) {
      return userHelper.authorize(loginDto);
   }

   @PostMapping("/register")
   public User authorize(@Valid @RequestBody UserDTO userDTO) {
      return userHelper.register(userDTO);
   }

}
