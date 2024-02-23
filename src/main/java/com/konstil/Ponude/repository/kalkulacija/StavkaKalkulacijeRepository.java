package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StavkaKalkulacijeRepository extends JpaRepository<StavkaKalkulacije, Long> {
    List<StavkaKalkulacije> getAllByKalkulacijaId(Long id);
}
