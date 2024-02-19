package com.konstil.Ponude.domain.ponuda;


import com.konstil.Ponude.controllers.ponuda.PonudaController;
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
    @Column(name = "datum_otvaranja")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Date datumOtvaranja;
    @Column(nullable = false, name = "rok_ponude")
    private Date rokPonude;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PonudaStatus status;
    private String opis;
}
