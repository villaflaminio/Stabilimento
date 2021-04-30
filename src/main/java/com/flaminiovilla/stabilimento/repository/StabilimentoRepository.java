package com.flaminiovilla.stabilimento.repository;

import com.flaminiovilla.stabilimento.model.Cliente;
import com.flaminiovilla.stabilimento.model.Stabilimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StabilimentoRepository extends JpaRepository<Stabilimento, Long> {

}
