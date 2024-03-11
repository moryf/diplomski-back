package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaDuzineKomada;
import com.konstil.Ponude.domain.kalkulacija.enumeracije.NacinRacunanjaKomada;
import com.konstil.Ponude.domain.ponuda.JedinicaMere;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import com.konstil.Ponude.exception.ServerException;
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
        try {
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
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kreiranja kalkulacije:"+e.getMessage());
        }
    }

    public Kalkulacija novakalkulacijaIzSablona(Long idSablona, Long idProizvodaPonude) {
        try {
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
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kreiranja kalkulacije:"+e.getMessage());
        }

    }

    public void kopirajStavkeKalkulacije(Kalkulacija sablon, Kalkulacija novaKalkulacije) {
        try {
            stavkaKalkulacijeRepository.getAllByKalkulacijaId(sablon.getId()).forEach(stavkaKalkulacije -> {
                entityManager.detach(stavkaKalkulacije);
                stavkaKalkulacije.setId(null);
                stavkaKalkulacije.setKalkulacija(novaKalkulacije);
                System.out.println(stavkaKalkulacije.getKalkulacija().getId());
                NacinRacunanjaKomada nacinRacunanjaKomada = stavkaKalkulacije.getNacinRacunanjaKomada();


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
                        NacinRacunanjaDuzineKomada nacinRacunanjaDuzineKomada = stavkaKalkulacije.getNacinRacunanjaDuzineKomada();
                        switch (nacinRacunanjaDuzineKomada){
                            case UPISANO:
                                                            ;
                                break;
                            case VISINA:
                                stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getVisinaPoKomadu());
                                stavkaKalkulacije.setDuzinaKomada(stavkaKalkulacije.getReferentnaDuzina()+stavkaKalkulacije.getRazlikaDuzine());
                                break;
                            case DUBINA:
                                stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDubinaPoKomadu());
                                stavkaKalkulacije.setDuzinaKomada(stavkaKalkulacije.getReferentnaDuzina()+stavkaKalkulacije.getRazlikaDuzine());
                                break;
                            case DUZINA:
                                stavkaKalkulacije.setReferentnaDuzina(stavkaKalkulacije.getKalkulacija().getProizvodPonuda().getDuzinaPoKomadu());
                                stavkaKalkulacije.setDuzinaKomada(stavkaKalkulacije.getReferentnaDuzina()+stavkaKalkulacije.getRazlikaDuzine());
                                break;
                            default:

                                break;
                        }

                        stavkaKalkulacije.setKolicina(stavkaKalkulacije.getKolicinaKomada()*stavkaKalkulacije.getDuzinaKomada());
                    }


                stavkaKalkulacijeRepository.save(stavkaKalkulacije);
            });
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kopiranja stavki kalkulacije:"+e.getMessage());
        }
    }

    public Kalkulacija kopirajKalkulaciju(Long idKalkulacije) {
        try {
            Kalkulacija kalkulacija = findById(idKalkulacije);
            Kalkulacija novaKalkulacije = new Kalkulacija();
            novaKalkulacije.setKreirao(kalkulacija.getKreirao());
            novaKalkulacije.setCinkovanje(kalkulacija.isCinkovanje());
            novaKalkulacije.setFarbanje(kalkulacija.isFarbanje());
            novaKalkulacije.setMontaza(kalkulacija.isMontaza());
            novaKalkulacije.setIzrada(kalkulacija.isIzrada());
            novaKalkulacije.setMaterijalPoKg(kalkulacija.getMaterijalPoKg());
            novaKalkulacije.setCinkovanjePoKg(kalkulacija.getCinkovanjePoKg());
            novaKalkulacije.setFarbanjePoM2(kalkulacija.getFarbanjePoM2());
            novaKalkulacije.setMontazaPoKg(kalkulacija.getMontazaPoKg());
            novaKalkulacije.setIzradaPoKg(kalkulacija.getIzradaPoKg());
            novaKalkulacije.setRezijskiTroskoviStepen(kalkulacija.getRezijskiTroskoviStepen());
            novaKalkulacije.setStepenSigurnosti(kalkulacija.getStepenSigurnosti());
            novaKalkulacije.setProizvodPonuda(kalkulacija.getProizvodPonuda());
            novaKalkulacije.setNaziv(kalkulacija.getNaziv()+" kopija "+new Date().toLocaleString());
            novaKalkulacije= save(novaKalkulacije);

            kopirajStavkeKalkulacije(kalkulacija, novaKalkulacije);

            return save(novaKalkulacije);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom kopiranja kalkulacije:"+e.getMessage());
        }
    }

    public List<Kalkulacija> getByPonudaId(Long idPonude) {
        try {
            return ((KalkulacijaRepository) repository).findByProizvodPonudaPonudaId(idPonude);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom pretrage kalkulacija:"+e.getMessage());
        }
    }
}
