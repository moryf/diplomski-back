package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.SablonKalkulacija;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.SablonKalkulacijaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SablonKalkulacijaService extends OpstiService<SablonKalkulacija, Long> {

    @Autowired
    public SablonKalkulacijaService(SablonKalkulacijaRepository repository) {
        this.repository = repository;
    }
    @Autowired
    KalkulacijaRepository kalkulacijaRepository;

    public SablonKalkulacija noviSablon(String naziv, Long idKalkulacije) {
        SablonKalkulacija sablonKalkulacija = new SablonKalkulacija();
        sablonKalkulacija.setNaziv(naziv);
        sablonKalkulacija.setKalkulacija(kalkulacijaRepository.findById(idKalkulacije).get());
        return repository.save(sablonKalkulacija);
    }

    public List<SablonKalkulacija> pronadjiPoNazivu(String naziv) {
        return ((SablonKalkulacijaRepository) repository).findByNazivContainingIgnoreCase(naziv);
    }
}
