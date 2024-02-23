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
        return ResponseEntity.ok(stavkaKalkulacijeService.getStavkeKalkulacijeByKalkulacijaId(id));
    }

    @PostMapping("/dodaj/kalkulacija/{id}")
    public ResponseEntity<?> dodajStavkuKalkulacije(@PathVariable Long id, @RequestBody StavkaKalkulacije stavkaKalkulacije){
        return ResponseEntity.ok(stavkaKalkulacijeService.dodajStavkuKalkulacije(id, stavkaKalkulacije));
    }
}
