package com.flaminiovilla.stabilimento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Stabilimento")
public class Stabilimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String nome ;

    @OneToMany(mappedBy = "stabilimento", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Ombrellone> ombrelloni;

    @OneToMany(mappedBy = "stabilimento", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Cliente> clienti;

    @OneToMany(mappedBy = "stabilimento", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

}
