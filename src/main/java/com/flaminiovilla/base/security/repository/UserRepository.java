package com.flaminiovilla.base.security.repository;

import com.flaminiovilla.base.security.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByEmail(String email);

   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

   User findByEmail(String username);
   Boolean existsByEmail(String username);
}
