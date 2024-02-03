package com.konstil.Ponude.domain.ponuda;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proizvodi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Proizvod {
    @Id
    private String sifra;
    @Column(nullable = false)
    private String naziv;
    @Column(nullable = false)
    private String opis;
    @Column(nullable = false)
    private String jedinicaMere;
    @Column(nullable = false)
    private float masa;
    @Column(nullable = false)
    private float specificnaPovrsina;
    @Column(nullable = false)
    private float cenaA;
    @Column(nullable = false)
    private float veleprodajnaCena;
}
