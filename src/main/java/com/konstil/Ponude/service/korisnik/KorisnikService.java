package com.konstil.Ponude.service.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import com.konstil.Ponude.domain.korisnik.Uloga;
import com.konstil.Ponude.repository.korisnik.KorisnikRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class KorisnikService extends OpstiService<Korisnik,Long> implements KorisnikServiceInterface {
    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.repository = korisnikRepository;
    }

    @Override
    public Korisnik findByUserName(String userName) {
        Korisnik korisnik = ((KorisnikRepository)repository).findByUsername(userName).get();
        return korisnik;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = ((KorisnikRepository)repository).findByUsername(username).get();
        if (korisnik == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                mapUlogetoAuthorities(korisnik.getUloge()));
    }

    private Collection<? extends GrantedAuthority> mapUlogetoAuthorities(Collection<Uloga> uloge) {
        return uloge.stream().map(uloga -> new SimpleGrantedAuthority(uloga.getNaziv())).collect(Collectors.toList());
    }
}
