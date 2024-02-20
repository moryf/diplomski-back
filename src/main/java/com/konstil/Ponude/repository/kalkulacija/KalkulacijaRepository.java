package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KalkulacijaRepository extends JpaRepository<Kalkulacija, Long> {
    List<Kalkulacija> findByProizvodPonudaId(Long id);
}
