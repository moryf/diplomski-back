package com.konstil.Ponude.domain.kalkulacija;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sablon_kalkulacije")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SablonKalkulacija {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String naziv;
    @ManyToOne
    Kalkulacija kalkulacija;
}
