package com.konstil.Ponude.domain;

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
    private String naziv;
    private String jedinicaMere;
    private float masa;
    private float specificnaPovrsina;
    private float cenaA;
    private float veleprodajnaCena;
}
