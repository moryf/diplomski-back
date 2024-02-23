package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import com.konstil.Ponude.repository.ponuda.ProizvodRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodService extends OpstiService<Proizvod,String> {

    @Autowired
    public ProizvodService(ProizvodRepository proizvodRepository) {
        this.repository = proizvodRepository;
    }

    public List<Proizvod> pretraziProizvode(String sifra, String naziv) {
        return ((ProizvodRepository) repository).findAllBySifraContainingAndNazivContainsIgnoreCase(sifra, naziv);
    }
}
