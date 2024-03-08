package com.konstil.Ponude.controllers.korisnik;

import com.konstil.Ponude.domain.korisnik.Korisnik;
import com.konstil.Ponude.dto.IzmenaSifreRequest;
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

    @PutMapping("/izmeni/{id}/ime={ime}/prezime={prezime}/korisnickoIme={korisnickoIme}")
    public ResponseEntity<?> izmeni(@PathVariable String id, @PathVariable String ime, @PathVariable String prezime, @PathVariable String korisnickoIme) {
        try {
            return ResponseEntity.ok(korisnikService.izmeni(id, ime, prezime, korisnickoIme));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/promeni-sifru/{id}")
    public ResponseEntity<?> promeniSifru(@PathVariable String id, @RequestBody IzmenaSifreRequest izmenaSifreRequest) {
        try {
            return ResponseEntity.ok(korisnikService.promeniSifru(id, izmenaSifreRequest.getStaraSifra(), izmenaSifreRequest.getNovaSifra()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
