package com.konstil.Ponude.service.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.korisnik.KorisnikRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService extends OpstiService<Korisnik,Long> {

    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.repository = korisnikRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Korisnik login(String korisnickoIme, String lozinka) {
        if (((KorisnikRepository) repository).findByKorisnickoIme(korisnickoIme).isEmpty()) {
            return null;
        }
        Korisnik korisnik = ((KorisnikRepository) repository).findByKorisnickoIme(korisnickoIme).get();
        if (korisnik != null && passwordEncoder.matches(lozinka, korisnik.getLozinka())) {
            return korisnik;
        }
        return null;
    }

    public Korisnik register(Korisnik korisnik) {
        try {
            korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));
            return save(korisnik);
        } catch (Exception e) {
            throw  new ServerException("Greska prilikom registracije korisnika"+e.getMessage());
        }
    }

    public Korisnik izmeni(String id, String ime, String prezime, String korisnickoIme) {
        try {
            Korisnik korisnik = findById(Long.parseLong(id));
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setKorisnickoIme(korisnickoIme);
            return save(korisnik);
        } catch (NumberFormatException e) {
            throw new ServerException("Greska prilikom izmene korisnika"+e.getMessage());
        }
    }

    public Korisnik promeniSifru(String id, String staraSifra, String novaSifra) {
        try {
            Korisnik korisnik = findById(Long.parseLong(id));
            if (passwordEncoder.matches(staraSifra, korisnik.getLozinka())) {
                korisnik.setLozinka(passwordEncoder.encode(novaSifra));
                return save(korisnik);
            }
            throw new ServerException("Pogresna stara sifra");
        } catch (NumberFormatException e) {
            throw new ServerException("Greska prilikom promene sifre"+e.getMessage());
        }
    }
}
