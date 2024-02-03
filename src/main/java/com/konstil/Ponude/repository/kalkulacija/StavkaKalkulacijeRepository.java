package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaKalkulacijeRepository extends JpaRepository<StavkaKalkulacije, Long> {
}
