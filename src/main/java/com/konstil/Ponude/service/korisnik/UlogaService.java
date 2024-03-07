package com.konstil.Ponude.service.korisnik;

import com.konstil.Ponude.domain.korisnik.Uloga;
import com.konstil.Ponude.repository.korisnik.UlogaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UlogaService extends OpstiService<Uloga,String> {
    @Autowired
    public UlogaService(UlogaRepository ulogaRepository) {
        this.repository = ulogaRepository;
    }
}
