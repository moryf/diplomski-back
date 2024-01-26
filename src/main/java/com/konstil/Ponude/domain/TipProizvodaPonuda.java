package com.konstil.Ponude.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "tipovi_proizvoda_ponuda")
public class TipProizvodaPonuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
}
