package com.konstil.Ponude.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fiksni_troskovi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FiksniTrosak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="kalukulacija_id",nullable = false)
    private Kalkulacija kalkulacija;
    private float cena;
    private String opis;
}
