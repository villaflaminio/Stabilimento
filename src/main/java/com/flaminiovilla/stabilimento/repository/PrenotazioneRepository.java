package com.flaminiovilla.stabilimento.repository;

import com.flaminiovilla.stabilimento.model.Cliente;
import com.flaminiovilla.stabilimento.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
