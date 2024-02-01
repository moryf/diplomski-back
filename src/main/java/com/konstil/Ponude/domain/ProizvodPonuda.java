package com.konstil.Ponude.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proizvodi_ponuda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProizvodPonuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ponuda_id",nullable = false)
    private Ponuda ponuda;

    @ManyToOne
    @JoinColumn(name = "tip_proizvoda_ponuda_id",nullable = false)
    private TipProizvodaPonuda tipProizvodaPonuda;

    private String naziv;
    private float ukupnoMetara;
    private float ukupnoKomada;
    private float duzinaPoKomadu;
    private float visinaPoKomadu;
    private float dubinaPoKomadu;
}
