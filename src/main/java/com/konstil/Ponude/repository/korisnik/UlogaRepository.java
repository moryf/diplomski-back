package com.konstil.Ponude.repository.korisnik;

import com.konstil.Ponude.domain.korisnik.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UlogaRepository extends JpaRepository<Uloga, String> {
}
