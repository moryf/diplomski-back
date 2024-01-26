package com.konstil.Ponude.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "proizvodi_ponuda")
public class ProizvodPonuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ponuda_id", referencedColumnName = "id")
    private Ponuda ponuda;

    @ManyToOne
    @JoinColumn(name = "tip_proizvoda_ponuda_id")
    private TipProizvodaPonuda tipProizvodaPonuda;

    private String naziv;
    private float ukupnoMetara;
    private float ukupnoKomada;
    private float duzinaPoKomadu;
    private float visinaPoKomadu;
    private float dubinaPoKomadu;
}
