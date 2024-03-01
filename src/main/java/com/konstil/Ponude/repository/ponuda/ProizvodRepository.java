package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, String> {
    List<Proizvod> findAllBySifraContainingAndNazivContainsIgnoreCaseAndOpisContainingIgnoreCase(String sifra, String naziv, String opis);

    @Query("select p.sifra from Proizvod p where p.sifra like ?1% order by p.sifra desc")
    List<String> getMaxSifra(String sifra);
}
