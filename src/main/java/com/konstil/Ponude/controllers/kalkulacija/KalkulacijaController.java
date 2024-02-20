package com.konstil.Ponude.controllers.kalkulacija;

import com.konstil.Ponude.service.kalkulacija.KalkulacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kalkulacija")
@CrossOrigin
public class KalkulacijaController {

    @Autowired
    KalkulacijaService kalkulacijaService;

    @GetMapping("/proizvod-ponuda/{id}")
    public ResponseEntity<?> getByProizvodPonudaId(@PathVariable Long id) {
        return ResponseEntity.ok(kalkulacijaService.getByProizvodPonudaId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(kalkulacijaService.findById(id));
    }

    @GetMapping("/proizvod-ponuda/{idProizvodaPonude}/korisnik/{idKorisnika}/nova")
    public ResponseEntity<?> novaKalkulacija( @PathVariable Long idProizvodaPonude, @PathVariable Long idKorisnika) {
        return ResponseEntity.ok(kalkulacijaService.novaKalkulacija(idProizvodaPonude, idKorisnika));
    }

}
