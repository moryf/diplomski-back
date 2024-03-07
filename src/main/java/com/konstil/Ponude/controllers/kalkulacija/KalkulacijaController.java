package com.konstil.Ponude.controllers.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.Kalkulacija;
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
        try {
            return ResponseEntity.ok(kalkulacijaService.getByProizvodPonudaId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(kalkulacijaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/proizvod-ponuda/{idProizvodaPonude}/korisnik/{idKorisnika}/nova")
    public ResponseEntity<?> novaKalkulacija( @PathVariable Long idProizvodaPonude, @PathVariable Long idKorisnika) {
        try {
            return ResponseEntity.ok(kalkulacijaService.novaKalkulacija(idProizvodaPonude, idKorisnika));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update( @RequestBody Kalkulacija kalkulacija) {
        try {
            return ResponseEntity.ok(kalkulacijaService.update(kalkulacija));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/sablon/{idSablona}/proizvod-ponuda/{idProizvodaPonude}/nova")
    public ResponseEntity<?> novakalkulacijaIzSablona( @PathVariable Long idSablona, @PathVariable Long idProizvodaPonude) {
        try {
            return ResponseEntity.ok(kalkulacijaService.novakalkulacijaIzSablona(idSablona, idProizvodaPonude));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("kopiraj/{idKalkulacije}")
    public ResponseEntity<?> kopirajKalkulaciju(@PathVariable Long idKalkulacije) {
        try {
            return ResponseEntity.ok(kalkulacijaService.kopirajKalkulaciju(idKalkulacije));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/ponuda/{idPonude}")
    public ResponseEntity<?> getByPonudaId(@PathVariable Long idPonude) {
        try {
            return ResponseEntity.ok(kalkulacijaService.getByPonudaId(idPonude));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
