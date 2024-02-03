package com.konstil.Ponude.domain.ponuda;

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
    @Column(nullable = false)
    private String naziv;
    @Column(nullable = false)
    private float ukupnoMetara;
    @Column(nullable = false)
    private float ukupnoKomada;
    @Column(nullable = false)
    private float duzinaPoKomadu;
    @Column(nullable = false)
    private float visinaPoKomadu;
    @Column(nullable = false)
    private float dubinaPoKomadu;
}
