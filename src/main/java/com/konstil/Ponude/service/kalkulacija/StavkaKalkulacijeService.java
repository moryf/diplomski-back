package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.exception.ServerException;
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
        try {
            return ((StavkaKalkulacijeRepository) repository).getAllByKalkulacijaId(id);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom pretrage stavki kalkulacije" + e.getMessage());
        }
    }

    public StavkaKalkulacije dodajStavkuKalkulacije(Long id, StavkaKalkulacije stavkaKalkulacije) {
        try {
            stavkaKalkulacije.setKalkulacija(kalkulacijaRepository.findById(id).get());
            return repository.save(stavkaKalkulacije);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dodavanja stavke kalkulacije" + e.getMessage());
        }
    }

    public List<StavkaKalkulacije> izmeniStavkeKalkulacije(List<StavkaKalkulacije> stavkeKalkulacije) {
        try {
            return repository.saveAll(stavkeKalkulacije);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom izmene stavki kalkulacije" + e.getMessage());
        }
    }

    public StavkaKalkulacije izmeniStavkuKalkulacije(StavkaKalkulacije stavkaKalkulacije) {
        try {
            return repository.save(stavkaKalkulacije);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom izmene stavke kalkulacije" + e.getMessage());
        }
    }

    public Long obrisiStavkuKalkulacije(Long id) {
        try {
            repository.deleteById(id);
            return id;
        } catch (Exception e) {
            throw new ServerException("Greska prilikom brisanja stavke kalkulacije" + e.getMessage());
        }
    }
}
