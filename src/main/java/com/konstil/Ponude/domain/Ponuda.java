package com.konstil.Ponude.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ponude")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ponuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    @ManyToOne
    @JoinColumn(name = "kupac_id", nullable = false)
    private Kupac kupac;
    private Date datumOtvaranja;
    private String status;
    private String opis;
}
