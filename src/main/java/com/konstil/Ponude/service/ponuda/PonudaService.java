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

import java.util.HashMap;
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
            throw ServerException.create("Greska prilikom cuvanja ponude, proverite da li kupac vec postoji u bazi: " + e.getMessage());
        }
    }

    public Ponuda promeniStatus(Long id, PonudaStatus ponudaStatus) {
        try {
            Ponuda ponuda = findById(id);
            ponuda.setStatus(ponudaStatus);
            return repository.save(ponuda);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom promene statusa ponude:" + e.getMessage());
        }
    }

    public List<Ponuda> findByStatus(PonudaStatus ponudaStatus) {
        try {
            return ((PonudaRepository) repository).findByStatusOrderByDatumOtvaranjaDesc(ponudaStatus);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja ponuda po statusu:" + e.getMessage());
        }

    }


    public List<Ponuda> findNezavrsene(){
        try {
            List<Ponuda> ponude = findByStatus(PonudaStatus.NOVA);
            ponude.addAll(findByStatus(PonudaStatus.OBRADJENA));
            return ponude;
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja nezavrsenih ponuda:" + e.getMessage());
        }
    }


    public HashMap<String,String> dashboard() {
        try {
            int nove = findByStatus(PonudaStatus.NOVA).size();
            int obradjene = findByStatus(PonudaStatus.OBRADJENA).size();
            int ponudeSaRokomOveNedelje = ((PonudaRepository) repository).ponudeSaRokomOveNedelje();
            int ponudaSaIsteklimRokom = ((PonudaRepository) repository).ponudeSaIsteklimRokom();
            int novihPonudaOveNedelje = ((PonudaRepository) repository).novihPonudaOveNedelje();

            HashMap<String,String> map = new HashMap<>();
            map.put("nove",String.valueOf(nove));
            map.put("obradjene",String.valueOf(obradjene));
            map.put("ponudeSaRokomOveNedelje",String.valueOf(ponudeSaRokomOveNedelje));
            map.put("ponudaSaIsteklimRokom",String.valueOf(ponudaSaIsteklimRokom));
            map.put("novihPonudaOveNedelje",String.valueOf(novihPonudaOveNedelje));
            return map;
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja dashboarda:" + e.getMessage());
        }
    }
}
