package com.flaminiovilla.stabilimento.security.service;

import com.flaminiovilla.stabilimento.security.SecurityUtils;
import com.flaminiovilla.stabilimento.security.model.User;
import com.flaminiovilla.stabilimento.security.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByEmail);
   }

}
