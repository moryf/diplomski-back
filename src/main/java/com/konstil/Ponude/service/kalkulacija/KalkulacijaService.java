package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.SablonKalkulacijaRepository;
import com.konstil.Ponude.repository.korisnik.KorisnikRepository;
import com.konstil.Ponude.repository.ponuda.ProizvodPonudaRepository;
import com.konstil.Ponude.repository.util.PodrazumevaneVrednostiRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KalkulacijaService extends OpstiService<Kalkulacija,Long> {
    @Autowired
    public KalkulacijaService(KalkulacijaRepository kalkulacijaRepository) {
        this.repository = kalkulacijaRepository;
    }

    @Autowired
    ProizvodPonudaRepository proizvodPonudaRepository;

    @Autowired
    PodrazumevaneVrednostiRepository podrazumevaneVrednostiRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    SablonKalkulacijaRepository sablonKalkulacijaRepository;

    public List<Kalkulacija> getByProizvodPonudaId(Long id) {
        return ((KalkulacijaRepository) repository).findByProizvodPonudaId(id);
    }

    public Kalkulacija novaKalkulacija(Long idProizvodaPonude, Long idKorisnika) {
        Kalkulacija kalkulacija = new Kalkulacija();
        kalkulacija.setKreirao(korisnikRepository.findById(idKorisnika).get());
        kalkulacija.setCinkovanje(false);
        kalkulacija.setFarbanje(false);
        kalkulacija.setMontaza(false);
        kalkulacija.setIzrada(false);

        kalkulacija.setMaterijalPoKg(podrazumevaneVrednostiRepository.findByOznaka("materijalPoKg").getVrednost());
        kalkulacija.setCinkovanjePoKg(podrazumevaneVrednostiRepository.findByOznaka("cinkovanjePoKg").getVrednost());
        kalkulacija.setFarbanjePoM2(podrazumevaneVrednostiRepository.findByOznaka("farbanjePoM2").getVrednost());
        kalkulacija.setMontazaPoKg(podrazumevaneVrednostiRepository.findByOznaka("montazaPoKg").getVrednost());
        kalkulacija.setIzradaPoKg(podrazumevaneVrednostiRepository.findByOznaka("izradaPoKg").getVrednost());
        kalkulacija.setRezijskiTroskoviStepen(podrazumevaneVrednostiRepository.findByOznaka("rezijskiTroskoviStepen").getVrednost());
        kalkulacija.setStepenSigurnosti(podrazumevaneVrednostiRepository.findByOznaka("stepenSigurnosti").getVrednost());
        kalkulacija.setProizvodPonuda(proizvodPonudaRepository.findById(idProizvodaPonude).get());
        kalkulacija.setNaziv(kalkulacija.getProizvodPonuda().getNaziv()+ " "+kalkulacija.getKreirao().getIme());
        return save(kalkulacija);
    }

    public Kalkulacija novakalkulacijaIzSablona(Long idSablona, Long idProizvodaPonude) {
        Kalkulacija novaKalkulacije = new Kalkulacija();
        Kalkulacija sablon = findById(sablonKalkulacijaRepository.findById(idSablona).get().getKalkulacija().getId());
        novaKalkulacije.setKreirao(sablon.getKreirao());
        novaKalkulacije.setCinkovanje(sablon.isCinkovanje());
        novaKalkulacije.setFarbanje(sablon.isFarbanje());
        novaKalkulacije.setMontaza(sablon.isMontaza());
        novaKalkulacije.setIzrada(sablon.isIzrada());
        novaKalkulacije.setMaterijalPoKg(sablon.getMaterijalPoKg());
        novaKalkulacije.setCinkovanjePoKg(sablon.getCinkovanjePoKg());
        novaKalkulacije.setFarbanjePoM2(sablon.getFarbanjePoM2());
        novaKalkulacije.setMontazaPoKg(sablon.getMontazaPoKg());
        novaKalkulacije.setIzradaPoKg(sablon.getIzradaPoKg());
        novaKalkulacije.setRezijskiTroskoviStepen(sablon.getRezijskiTroskoviStepen());
        novaKalkulacije.setStepenSigurnosti(sablon.getStepenSigurnosti());
        novaKalkulacije.setProizvodPonuda(proizvodPonudaRepository.findById(idProizvodaPonude).get());
        novaKalkulacije.setNaziv(novaKalkulacije.getProizvodPonuda().getNaziv()+ " "+novaKalkulacije.getKreirao().getIme());
        return save(novaKalkulacije);

    }
}
