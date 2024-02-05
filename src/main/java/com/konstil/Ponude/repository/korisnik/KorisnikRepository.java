package com.konstil.Ponude.repository.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    public Optional<Korisnik> findByUsername(String username);
}
