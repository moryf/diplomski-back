package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, String> {
    List<Proizvod> findAllBySifraContainingAndNazivContainsIgnoreCase(String sifra, String naziv);
}
