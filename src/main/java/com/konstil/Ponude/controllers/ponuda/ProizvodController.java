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
        return ResponseEntity.ok(proizvodService.findAll());
    }


    @GetMapping("/pretrazi/sifra={sifra}/naziv={naziv}/opis={opis}")
    public ResponseEntity<?> pretraziProizvode(@PathVariable String sifra,@PathVariable String naziv, @PathVariable String opis) {
        return ResponseEntity.ok(proizvodService.pretraziProizvode(sifra, naziv, opis));
    }

    @PostMapping("/sacuvaj")
    public ResponseEntity<?> sacuvajProizvod(@RequestBody Proizvod proizvod) {
        return ResponseEntity.ok(proizvodService.novi(proizvod));
    }
}
