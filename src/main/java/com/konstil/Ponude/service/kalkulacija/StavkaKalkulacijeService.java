package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.repository.kalkulacija.StavkaKalkulacijeRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StavkaKalkulacijeService extends OpstiService<StavkaKalkulacije,Long> {
    @Autowired
    public StavkaKalkulacijeService(StavkaKalkulacijeRepository stavkaKalkulacijeRepository) {
        this.repository = stavkaKalkulacijeRepository;
    }

    public List<StavkaKalkulacije> getStavkeKalkulacijeByKalkulacijaId(Long id) {
        return ((StavkaKalkulacijeRepository) repository).getAllByKalkulacijaId(id);
    }

    public List<StavkaKalkulacije> updateStavkeKalkulacijeByKalkulacijaId(Long id, List<StavkaKalkulacije> stavkeKalkulacije) {
        List<StavkaKalkulacije> stavkeKalkulacijeIzBaze = ((StavkaKalkulacijeRepository) repository).getAllByKalkulacijaId(id);
        for (StavkaKalkulacije stavkaKalkulacije : stavkeKalkulacijeIzBaze) {
            if (!stavkeKalkulacije.contains(stavkaKalkulacije)) {
                repository.delete(stavkaKalkulacije);
            }
        }
        for (StavkaKalkulacije stavkaKalkulacije : stavkeKalkulacije) {
            save(stavkaKalkulacije);
        }
        return ((StavkaKalkulacijeRepository) repository).getAllByKalkulacijaId(id);
    }
}
