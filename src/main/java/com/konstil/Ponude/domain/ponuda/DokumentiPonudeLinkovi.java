package com.konstil.Ponude.domain.ponuda;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DokumentiPonudeLinkovi {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String link;
    @ManyToOne
    private Ponuda ponuda;
    @ManyToOne
    private Korisnik uneoKorisnik;
    private Date datumUnosa = new Date();
}
