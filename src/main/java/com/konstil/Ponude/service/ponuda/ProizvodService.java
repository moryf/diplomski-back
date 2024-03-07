package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.JedinicaMere;
import com.konstil.Ponude.domain.ponuda.Proizvod;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.ponuda.ProizvodRepository;
import com.konstil.Ponude.repository.util.PodrazumevaneVrednostiRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class ProizvodService extends OpstiService<Proizvod,String> {

    @Autowired
    public ProizvodService(ProizvodRepository proizvodRepository) {
        this.repository = proizvodRepository;
    }

    @Autowired
    PodrazumevaneVrednostiRepository podrazumevaneVrednostiRepository;

    public List<Proizvod> pretraziProizvode(String sifra, String naziv, String opis) {
        try {
            System.out.println("sifra: "+sifra+" naziv: "+naziv+" opis: "+opis);
            return ((ProizvodRepository) repository).findAllBySifraContainingAndNazivContainsIgnoreCaseAndOpisContainingIgnoreCase(sifra, naziv, opis);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom pretrage proizvoda:" + e.getMessage());
        }
    }

    public Proizvod novi(Proizvod proizvod) {
        try {
            String sifra = "11";
            if(proizvod.getJedinicaMere()== JedinicaMere.KOMAD){
                sifra=sifra+"00";
            }else {
                sifra=sifra+"01";
            }

            List<String> maxSifra = ((ProizvodRepository) repository).getMaxSifra(sifra);

            if(!maxSifra.isEmpty()){
                 sifra = String.valueOf(parseInt(maxSifra.get(0))+1);
            }else {
                sifra = sifra + "0001";
            }

            proizvod.setSifra(sifra);
            if(proizvod.getNaziv().length()>50){
                proizvod.setNaziv(proizvod.getNaziv().substring(0,50));
            }
            if(proizvod.getOpis().length()>100){
                proizvod.setOpis(proizvod.getOpis().substring(0,100));
            }
            if(proizvod.getCenaA()==0 && proizvod.getVeleprodajnaCena()==0){
                proizvod.setCenaA((float) podrazumevaneVrednostiRepository.findById("materijalPoKg").get().getVrednost()*proizvod.getMasa());
                proizvod.setVeleprodajnaCena((float) (podrazumevaneVrednostiRepository.findById("materijalPoKg").get().getVrednost()*proizvod.getMasa()*1.2));
            }
            return repository.save(proizvod);
        } catch (NumberFormatException e) {
            throw new ServerException("Greska prilikom kreiranja novog proizvoda:" + e.getMessage());
        }

    }
}
