package com.konstil.Ponude.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "kalkulacije")
public class Kalkulacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="proizvod_ponuda_id", referencedColumnName = "id")
    private ProizvodPonuda proizvodPonuda;
    private boolean cinkovanje;
    private boolean farbanje;
    private boolean montaza;
    private boolean izrada;
    private float materijalPoKg;
    private float cinkovanjePoKg;
    private float farbanjePoM2;
    private float montazaPoKg;
    private float izradaPoKg;
    private float rezijskiTroskoviStepen;
    private float stepenSigurnosti;
    private String koriscenjeCene;
}
