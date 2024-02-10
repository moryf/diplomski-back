package com.konstil.Ponude.domain.ponuda;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "ponude")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ponuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @ManyToOne
    @JoinColumn(name = "kupac_id", nullable = false)
    private Kupac kupac;
    @Column(nullable = false, name = "datum_otvaranja")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Date datumOtvaranja;
    @Column(nullable = false, name = "rok_ponude")
    private Date rokPonude;
    @Column(nullable = false)
    private String status;
    private String opis;
}
