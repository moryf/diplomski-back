package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.SablonKalkulacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SablonKalkulacijaRepository extends JpaRepository<SablonKalkulacija, Long> {
    List<SablonKalkulacija> findByNazivContainingIgnoreCase(String naziv);
}
