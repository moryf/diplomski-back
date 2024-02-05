package com.konstil.Ponude.service.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface KorisnikServiceInterface extends UserDetailsService {

        public Korisnik findByUserName(String userName);
}
