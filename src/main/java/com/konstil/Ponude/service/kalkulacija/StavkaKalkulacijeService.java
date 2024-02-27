package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
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
    @Autowired
    KalkulacijaRepository kalkulacijaRepository;

    public List<StavkaKalkulacije> getStavkeKalkulacijeByKalkulacijaId(Long id) {
        return ((StavkaKalkulacijeRepository) repository).getAllByKalkulacijaId(id);
    }

    public StavkaKalkulacije dodajStavkuKalkulacije(Long id, StavkaKalkulacije stavkaKalkulacije) {
        stavkaKalkulacije.setKalkulacija(kalkulacijaRepository.findById(id).get());
        return repository.save(stavkaKalkulacije);
    }

    public List<StavkaKalkulacije> izmeniStavkeKalkulacije(List<StavkaKalkulacije> stavkeKalkulacije) {
        return repository.saveAll(stavkeKalkulacije);
    }
}
