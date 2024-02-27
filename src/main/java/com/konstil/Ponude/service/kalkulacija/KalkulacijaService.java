package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaDuzineKomada;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaKomada;
import com.konstil.Ponude.domain.ponuda.JedinicaMere;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import com.konstil.Ponude.repository.kalkulacija.KalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.SablonKalkulacijaRepository;
import com.konstil.Ponude.repository.kalkulacija.StavkaKalkulacijeRepository;
import com.konstil.Ponude.repository.korisnik.KorisnikRepository;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.repository.ponuda.ProizvodPonudaRepository;
import com.konstil.Ponude.repository.util.PodrazumevaneVrednostiRepository;
import com.konstil.Ponude.service.OpstiService;
import jakarta.persistence.EntityManager;
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

    @Autowired
    PonudaRepository ponudaRepository;

    @Autowired
    StavkaKalkulacijeRepository stavkaKalkulacijeRepository;

    @Autowired
    EntityManager entityManager;


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

        if(kalkulacija.getProizvodPonuda().getPonuda().getStatus() == PonudaStatus.NOVA){
            kalkulacija.getProizvodPonuda().getPonuda().setStatus(PonudaStatus.OBRADJENA);
            ponudaRepository.save(kalkulacija.getProizvodPonuda().getPonuda());
        }


        return save(kalkulacija);
    }

    public Kalkulacija novakalkulacijaIzSablona(Long idSablona, Long idProizvodaPonude) {
        Kalkulacija novaKalkulacije = new Kalkulacija();
        System.out.println(idSablona+ " "+sablonKalkulacijaRepository.findById(idSablona).get().getKalkulacija().getId() );
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




        if(novaKalkulacije.getProizvodPonuda().getPonuda().getStatus() == PonudaStatus.NOVA){
            novaKalkulacije.getProizvodPonuda().getPonuda().setStatus(PonudaStatus.OBRADJENA);
            ponudaRepository.save(novaKalkulacije.getProizvodPonuda().getPonuda());
        }

        novaKalkulacije= save(novaKalkulacije);

        kopirajStavkeKalkulacije(sablon, novaKalkulacije);

        return save(novaKalkulacije);

    }

    private void kopirajStavkeKalkulacije(Kalkulacija sablon, Kalkulacija novaKalkulacije) {
        stavkaKalkulacijeRepository.getAllByKalkulacijaId(sablon.getId()).forEach(stavkaKalkulacije -> {
            entityManager.detach(stavkaKalkulacije);
            stavkaKalkulacije.setId(null);
            stavkaKalkulacije.setKalkulacija(novaKalkulacije);
            System.out.println(stavkaKalkulacije.getKalkulacija().getId());
            NacinRacunanjaKomada nacinRacunanjaKomada = stavkaKalkulacije.getNacinRacunanjaKomada();
            NacinRacunanjaDuzineKomada nacinRacunanjaDuzineKomada = stavkaKalkulacije.getNacinRacunanjaDuzineKomada();

                switch (nacinRacunanjaKomada){
                    case KOMAD:
                        break;
                    case PO_DUZNOM_METRU:
                        stavkaKalkulacije.setKolicinaKomada((int) ((stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDuzinaPoKomadu()/stavkaKalkulacije.getRazmak()+stavkaKalkulacije.getRucniDodatak())*stavkaKalkulacije.getMultiplikator()));
                        break;
                    case PO_VISINSKOM_METRU:
                        stavkaKalkulacije.setKolicinaKomada((int) ((stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getVisinaPoKomadu()/stavkaKalkulacije.getRazmak()+stavkaKalkulacije.getRucniDodatak())*stavkaKalkulacije.getMultiplikator()));
                        break;
                    case PO_DUBINSKOM_METRU:
                        stavkaKalkulacije.setKolicinaKomada((int) ((stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDubinaPoKomadu()/stavkaKalkulacije.getRazmak()+stavkaKalkulacije.getRucniDodatak())*stavkaKalkulacije.getMultiplikator()));
                        break;
                    default:
                        break;
                }

                if (stavkaKalkulacije.getProizvod().getJedinicaMere()==JedinicaMere.KOMAD){
                    stavkaKalkulacije.setKolicina(stavkaKalkulacije.getKolicinaKomada());
                }
                else {
                    switch (nacinRacunanjaDuzineKomada){
                        case UPISANO:
                            stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getDuzinaKomada());
                            break;
                        case VISINA:
                            stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getVisinaPoKomadu());
                            break;
                        case DUBINA:
                            stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDubinaPoKomadu());
                            break;
                        case DUZINA:
                            stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDuzinaPoKomadu());
                            break;
                        default:
                            stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getDuzinaKomada());
                            break;
                    }
                    stavkaKalkulacije.setDuzinaKomada(stavkaKalkulacije.getReferentnaDuzina()+stavkaKalkulacije.getRazlikaDuzine());
                    stavkaKalkulacije.setKolicina(stavkaKalkulacije.getKolicinaKomada()*stavkaKalkulacije.getDuzinaKomada());
                }


            stavkaKalkulacijeRepository.save(stavkaKalkulacije);
        });
    }
}
