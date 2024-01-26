package com.konstil.Ponude.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "proizvodi")
public class Proizvod {
    @Id
    private String sifra;
    private String naziv;
    private String jedinicaMere;
    private float masa;
    private float specificnaPovrsina;
    private float cenaA;
    private float veleprodajnaCena;
}
