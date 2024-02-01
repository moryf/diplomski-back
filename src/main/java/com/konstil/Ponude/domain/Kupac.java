package com.konstil.Ponude.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kupci")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kupac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imeIPrezime;
    private String adresa;
    @Column(nullable = false, unique = true)
    private String brojTelefona;
    private String email;
}