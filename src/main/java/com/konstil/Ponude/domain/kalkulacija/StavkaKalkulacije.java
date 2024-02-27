package com.konstil.Ponude.domain.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaDuzineKomada;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaKomada;
import com.konstil.Ponude.domain.ponuda.Proizvod;
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

    @Enumerated(EnumType.STRING)
    NacinRacunanjaKomada nacinRacunanjaKomada;
    float razmak;
    float multiplikator;
    int rucniDodatak;
    int kolicinaKomada;

    @Enumerated(EnumType.STRING)
    NacinRacunanjaDuzineKomada nacinRacunanjaDuzineKomada;
    float referentnaDuzina;
    float razlikaDuzine;
    float duzinaKomada;


    @Column(nullable = false)
    private float kolicina;
    @Column(nullable = false)
    private boolean cinkovanje;
    @Column(nullable = false)
    private boolean farbanje;
    @Column(nullable = false)
    private boolean montaza;
    @Column(nullable = false)
    private boolean izrada;
    @Column(nullable = false)
    private float cena;
}
