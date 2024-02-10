package com.konstil.Ponude.domain.korisnik;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Uloga {
    @Id
    String naziv;

    @Override
    public String toString() {
        return "Uloga{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
