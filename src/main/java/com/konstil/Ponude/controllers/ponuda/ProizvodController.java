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




    @GetMapping("/pretrazi/sifra={sifra}/naziv={naziv}")
    public ResponseEntity<?> pretraziProizvode(@PathVariable String sifra,@PathVariable String naziv) {
        System.out.println("sifra: " + sifra + " naziv: " + naziv);
        return ResponseEntity.ok(proizvodService.pretraziProizvode(sifra, naziv));
    }
}
