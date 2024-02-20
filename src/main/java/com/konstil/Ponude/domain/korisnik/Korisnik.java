package com.konstil.Ponude.domain.korisnik;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Korisnik {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String ime;
    @Column(nullable = false)
    String prezime;
    @Column(nullable = false , unique = true)
    String korisnickoIme;
    @Column(nullable = false)
    String lozinka;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "korisnik_uloga",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "uloga_naziv")
    )
    List<Uloga> uloge;
}