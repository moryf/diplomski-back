package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.Kupac;
import com.konstil.Ponude.service.ponuda.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kupac")
@CrossOrigin
public class KupacController {
    @Autowired
    KupacService kupacService;

    @PostMapping("/dodaj")
    public ResponseEntity<?> dodajKupca(@RequestBody Kupac kupac) {
        return ResponseEntity.ok(kupacService.save(kupac));
    }

    @GetMapping("/pretrazi/imeIPrezime={imeIPrezime}&brojTelefona={brojTelefona}")
    public ResponseEntity<?> pretraziKupce(@PathVariable String imeIPrezime, @PathVariable String brojTelefona) {
        return ResponseEntity.ok(kupacService.pretraziKupce(imeIPrezime, brojTelefona));
    }


}
