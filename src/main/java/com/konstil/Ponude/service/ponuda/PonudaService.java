package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.ponuda.KupacRepository;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PonudaService extends OpstiService<Ponuda,Long> {
    @Autowired
    public PonudaService(PonudaRepository ponudaRepository) {
        this.repository = ponudaRepository;
    }
    @Autowired
    KupacRepository kupacRepository;


    public Ponuda novaPonuda(Ponuda ponuda) throws Exception {
        try {
            ponuda.setKupac(kupacRepository.save(ponuda.getKupac()));
            return repository.save(ponuda);
        }
        catch (Exception e){
            e.printStackTrace();
            throw ServerException.create("Greska prilikom cuvanja ponude");
        }
    }
}
