package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import com.konstil.Ponude.service.ponuda.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proizvod")
@CrossOrigin
public class ProizvodController {

    @Autowired
    ProizvodService proizvodService;


    @GetMapping("/svi")
    public ResponseEntity<?> sviProizvodi() {
        try {
            return ResponseEntity.ok(proizvodService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/pretrazi/sifra={sifra}/naziv={naziv}/opis={opis}")
    public ResponseEntity<?> pretraziProizvode(@PathVariable String sifra,@PathVariable String naziv, @PathVariable String opis) {
        try {
            return ResponseEntity.ok(proizvodService.pretraziProizvode(sifra, naziv, opis));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/sacuvaj")
    public ResponseEntity<?> sacuvajProizvod(@RequestBody Proizvod proizvod) {
        try {
            return ResponseEntity.ok(proizvodService.novi(proizvod));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/izmeni")
    public ResponseEntity<?> izmeniProizvod(@RequestBody Proizvod proizvod) {
        try {
            return ResponseEntity.ok(proizvodService.update(proizvod));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
