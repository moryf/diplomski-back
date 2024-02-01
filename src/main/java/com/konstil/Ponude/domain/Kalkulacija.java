package com.konstil.Ponude.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kalkulacije")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Kalkulacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="proizvod_ponuda_id",nullable = false)
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
