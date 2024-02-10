package com.konstil.Ponude.controllers.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import com.konstil.Ponude.dto.LoginRequest;
import com.konstil.Ponude.service.korisnik.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/korisnik")
@CrossOrigin
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest korisnik) {
        Korisnik korisnik1 = korisnikService.login(korisnik.getKorisnickoIme(), korisnik.getLozinka());
        if (korisnik1 != null) {
            return ResponseEntity.ok(korisnik1);
        }
        return ResponseEntity.badRequest().body("Pogresno korisnicko ime ili lozinka");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Korisnik korisnik) {
        try {
            return ResponseEntity.ok(korisnikService.register(korisnik));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
