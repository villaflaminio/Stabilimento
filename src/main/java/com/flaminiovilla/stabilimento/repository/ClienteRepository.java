package com.flaminiovilla.stabilimento.repository;

import com.flaminiovilla.stabilimento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
