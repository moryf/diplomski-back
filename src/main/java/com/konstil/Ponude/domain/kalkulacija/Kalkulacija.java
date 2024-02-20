package com.konstil.Ponude.domain.kalkulacija;

import com.konstil.Ponude.domain.ponuda.ProizvodPonuda;
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
    @Column(nullable = false)
    private boolean cinkovanje = false;
    @Column(nullable = false)
    private boolean farbanje = false;
    @Column(nullable = false)
    private boolean montaza = false;
    @Column(nullable = false)
    private boolean izrada = false;
    @Column(nullable = false)
    private float materijalPoKg;
    @Column(nullable = false)
    private float cinkovanjePoKg;
    @Column(nullable = false)
    private float farbanjePoM2;
    @Column(nullable = false)
    private float montazaPoKg;
    @Column(nullable = false)
    private float izradaPoKg;
    @Column(nullable = false)
    private float rezijskiTroskoviStepen;
    @Column(nullable = false)
    private float stepenSigurnosti;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KoriscenjeCene koriscenjeCene = KoriscenjeCene.VELEPRODAJNA_CENA;
}