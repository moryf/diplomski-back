package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.repository.kalkulacija.StavkaKalkulacijeRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;

public class StavkaKalkulacijeService extends OpstiService<StavkaKalkulacije,Long> {
    @Autowired
    public StavkaKalkulacijeService(StavkaKalkulacijeRepository stavkaKalkulacijeRepository) {
        this.repository = stavkaKalkulacijeRepository;
    }
}
