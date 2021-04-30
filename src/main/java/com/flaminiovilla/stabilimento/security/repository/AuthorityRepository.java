package com.flaminiovilla.stabilimento.security.repository;

import com.flaminiovilla.stabilimento.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Authority getByName(String name);
}
