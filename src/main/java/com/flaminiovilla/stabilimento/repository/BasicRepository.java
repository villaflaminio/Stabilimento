package com.flaminiovilla.stabilimento.repository;

import com.flaminiovilla.stabilimento.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
    Boolean existsByEmail(String username);
}
