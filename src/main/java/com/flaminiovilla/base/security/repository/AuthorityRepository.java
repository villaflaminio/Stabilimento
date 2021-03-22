package com.flaminiovilla.base.security.repository;

import com.flaminiovilla.base.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Authority getByName(String name);
}
