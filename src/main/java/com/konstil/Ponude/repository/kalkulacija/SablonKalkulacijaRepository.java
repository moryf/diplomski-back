package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.SablonKalkulacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SablonKalkulacijaRepository extends JpaRepository<SablonKalkulacija, Long> {
    List<SablonKalkulacija> findByNazivContainingIgnoreCase(String naziv);
}
