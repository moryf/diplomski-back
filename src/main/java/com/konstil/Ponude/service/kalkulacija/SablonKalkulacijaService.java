package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import com.konstil.Ponude.domain.kalkulacija.SablonKalkulacija;
import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaDuzineKomada;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaKomada;
import com.konstil.Ponude.domain.ponuda.JedinicaMere;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.SablonKalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.StavkaKalkulacijeRepository;
import com.konstil.Ponude.service.OpstiService;
import jakarta.persistence.EntityManager;
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
    @Autowired
    EntityManager entityManager;
    @Autowired
    StavkaKalkulacijeRepository stavkaKalkulacijeRepository;

    public SablonKalkulacija noviSablon(String naziv, Long idKalkulacije) {
        try {
            SablonKalkulacija sablonKalkulacija = new SablonKalkulacija();
            sablonKalkulacija.setNaziv(naziv);
            Kalkulacija kalkulacijaCopy = kalkulacijaRepository.findById(idKalkulacije).get();
            entityManager.detach(kalkulacijaCopy);
            kalkulacijaCopy.setId(null);

            kalkulacijaCopy.setNaziv(kalkulacijaCopy.getNaziv() + "*SABLON*");
            kalkulacijaRepository.save(kalkulacijaCopy);
            sablonKalkulacija.setKalkulacija(kalkulacijaCopy);
            kopirajStavkeKalkulacije(kalkulacijaRepository.findById(idKalkulacije).get(), kalkulacijaCopy);

            kalkulacijaCopy.setProizvodPonuda(null);
            return repository.save(sablonKalkulacija);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kreiranja sablona kalkulacije" + e.getMessage());
        }
    }

    public List<SablonKalkulacija> pronadjiPoNazivu(String naziv) {
        try {
            return ((SablonKalkulacijaRepository) repository).findByNazivContainingIgnoreCase(naziv);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom pretrage sablona kalkulacije" + e.getMessage());
        }
    }


    public void kopirajStavkeKalkulacije(Kalkulacija sablon, Kalkulacija novaKalkulacije) {
        try {
            stavkaKalkulacijeRepository.getAllByKalkulacijaId(sablon.getId()).forEach(stavkaKalkulacije -> {
                entityManager.detach(stavkaKalkulacije);
                stavkaKalkulacije.setId(null);
                stavkaKalkulacije.setKalkulacija(novaKalkulacije);
                stavkaKalkulacijeRepository.save(stavkaKalkulacije);
            });
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kopiranja stavki kalkulacije" + e.getMessage());
        }
    }
}
