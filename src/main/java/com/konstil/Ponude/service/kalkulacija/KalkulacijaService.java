package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;

public class KalkulacijaService extends OpstiService<Kalkulacija,Long> {
    @Autowired
    public KalkulacijaService(KalkulacijaRepository kalkulacijaRepository) {
        this.repository = kalkulacijaRepository;
    }
}
