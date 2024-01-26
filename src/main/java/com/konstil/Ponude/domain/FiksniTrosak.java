package com.konstil.Ponude.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fiksni_troskovi")
public class FiksniTrosak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="kalukulacija_id", referencedColumnName = "id")
    private Kalkulacija kalkulacija;
    private float cena;
    private String opis;
}
