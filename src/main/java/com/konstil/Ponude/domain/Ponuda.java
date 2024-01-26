package com.konstil.Ponude.domain;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ponude")
public class Ponuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    @ManyToOne
    private Kupac kupac;
    private Date datumOtvaranja;
    private String status;
    private String opis;
}
