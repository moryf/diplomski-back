package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.Kupac;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.ponuda.KupacRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacService extends OpstiService<Kupac,Long> {
    @Autowired
    public KupacService(KupacRepository kupacRepository) {
        this.repository = kupacRepository;
    }

    public List<Kupac> pretraziKupce(String imeIPrezime, String brojTelefona) {
        try {
            return ((KupacRepository) repository).pretraziKupce(imeIPrezime, brojTelefona);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom pretrage kupaca:" + e.getMessage());
        }
    }
}
