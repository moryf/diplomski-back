package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.korisnik.KorisnikRepository;
import com.konstil.Ponude.repository.ponuda.KupacRepository;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PonudaService extends OpstiService<Ponuda,Long> {
    @Autowired
    public PonudaService(PonudaRepository ponudaRepository) {
        this.repository = ponudaRepository;
    }
    @Autowired
    KupacRepository kupacRepository;
    @Autowired
    KorisnikRepository korisnikRepository;


    public Ponuda novaPonuda(Ponuda ponuda) throws Exception {
        try {
            ponuda.setNaziv("P-" + repository.count() + "-" + java.time.LocalDate.now().getYear());
            ponuda.setKupac(kupacRepository.save(ponuda.getKupac()));
            ponuda.setOtvorioPonudu(korisnikRepository.findById(ponuda.getOtvorioPonudu().getId()).get());
            return repository.save(ponuda);
        }
        catch (Exception e){
            e.printStackTrace();
            throw ServerException.create("Greska prilikom cuvanja ponude");
        }
    }

    public Ponuda promeniStatus(Long id, PonudaStatus ponudaStatus) {
        Ponuda ponuda = findById(id);
        ponuda.setStatus(ponudaStatus);
        return repository.save(ponuda);
    }

    public List<Ponuda> findByStatus(PonudaStatus ponudaStatus) {
        return ((PonudaRepository) repository).findByStatus(ponudaStatus);

    }
}
