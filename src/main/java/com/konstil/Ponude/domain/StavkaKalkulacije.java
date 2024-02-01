package com.konstil.Ponude.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stavke_kalkulacije")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StavkaKalkulacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="kalkulacija_id",nullable = false)
    private Kalkulacija kalkulacija;

    @ManyToOne
    @JoinColumn(name="sifra_proizvoda",nullable = false)
    private Proizvod proizvod;
    private float kolicina;
    private boolean cinkovanje;
    private boolean farbanje;
    private boolean montaza;
    private boolean izrada;
}
