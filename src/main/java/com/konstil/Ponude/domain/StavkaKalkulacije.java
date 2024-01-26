package com.konstil.Ponude.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "stavke_kalkulacije")
public class StavkaKalkulacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @ManyToOne
    @JoinColumn(name="kalkulacija_id")
    private Kalkulacija kalkulacija;
    @Id
    @ManyToOne
    @JoinColumn(name="sifra_proizvoda")
    private Proizvod proizvod;
    private float kolicina;
    private boolean cinkovanje;
    private boolean farbanje;
    private boolean montaza;
    private boolean izrada;
}
