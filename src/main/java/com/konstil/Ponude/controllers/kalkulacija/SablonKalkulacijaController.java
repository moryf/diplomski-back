package com.konstil.Ponude.controllers.kalkulacija;

import com.konstil.Ponude.service.kalkulacija.SablonKalkulacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sablon-kalkulacija")
@CrossOrigin
public class SablonKalkulacijaController {
    @Autowired
    SablonKalkulacijaService sablonKalkulacijaService;

    @GetMapping("/svi")
    public ResponseEntity<?> sviSabloni() {
        try {
            return ResponseEntity.ok(sablonKalkulacijaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(sablonKalkulacijaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/sacuvaj/{idKalkulacije}/naziv={naziv}")
    public ResponseEntity<?> noviSablon(@PathVariable String naziv, @PathVariable Long idKalkulacije) {
        try {
            return ResponseEntity.ok(sablonKalkulacijaService.noviSablon(naziv, idKalkulacije));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @GetMapping("/naziv={naziv}")
    public ResponseEntity<?> pronadjiPoNazivu(@PathVariable String naziv) {
        try {
            return ResponseEntity.ok(sablonKalkulacijaService.pronadjiPoNazivu(naziv));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
