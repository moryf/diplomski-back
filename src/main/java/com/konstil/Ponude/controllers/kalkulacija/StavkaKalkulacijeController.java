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


    @PutMapping("/kalkulacija/{id}")
    public ResponseEntity<?> updateStavkeKalkulacijeByKalkulacijaId(@PathVariable Long id, @RequestBody List<StavkaKalkulacije> stavkeKalkulacije){
        return ResponseEntity.ok(stavkaKalkulacijeService.updateStavkeKalkulacijeByKalkulacijaId(id, stavkeKalkulacije));

    }
}
