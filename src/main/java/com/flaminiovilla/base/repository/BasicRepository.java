package com.flaminiovilla.base.repository;

import com.flaminiovilla.base.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
    Boolean existsByEmail(String username);
}
