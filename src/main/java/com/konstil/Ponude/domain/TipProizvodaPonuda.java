package com.konstil.Ponude.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipovi_proizvoda_ponuda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipProizvodaPonuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
}
