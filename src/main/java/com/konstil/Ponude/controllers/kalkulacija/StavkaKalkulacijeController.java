package com.konstil.Ponude.controllers.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.StavkaKalkulacije;
import com.konstil.Ponude.service.kalkulacija.StavkaKalkulacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stavka-kalkulacije")
@CrossOrigin
public class StavkaKalkulacijeController {
    @Autowired
    StavkaKalkulacijeService stavkaKalkulacijeService;



    @GetMapping("/kalkulacija/{id}")
    public ResponseEntity<?> getStavkeKalkulacijeByKalkulacijaId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(stavkaKalkulacijeService.getStavkeKalkulacijeByKalkulacijaId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/dodaj/kalkulacija/{id}")
    public ResponseEntity<?> dodajStavkuKalkulacije(@PathVariable Long id, @RequestBody StavkaKalkulacije stavkaKalkulacije){
        try {
            return ResponseEntity.ok(stavkaKalkulacijeService.dodajStavkuKalkulacije(id, stavkaKalkulacije));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/izmeni/lista")
    public ResponseEntity<?> izmeniStavkeKalkulacije(@RequestBody List<StavkaKalkulacije> stavkeKalkulacije){
        try {
            return ResponseEntity.ok(stavkaKalkulacijeService.izmeniStavkeKalkulacije(stavkeKalkulacije));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/izmeni")
    public ResponseEntity<?> izmeniStavkuKalkulacije(@RequestBody StavkaKalkulacije stavkaKalkulacije){
        try {
            return ResponseEntity.ok(stavkaKalkulacijeService.izmeniStavkuKalkulacije(stavkaKalkulacije));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/obrisi/{id}")
    public ResponseEntity<?> obrisiStavkuKalkulacije(@PathVariable Long id){
        try {
            return ResponseEntity.ok(stavkaKalkulacijeService.obrisiStavkuKalkulacije(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
