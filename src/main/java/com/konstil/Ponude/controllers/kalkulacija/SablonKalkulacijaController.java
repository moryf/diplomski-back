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


    @PostMapping("/sacuvaj/{idKalkulacije}/naziv={naziv}")
    public ResponseEntity<?> noviSablon(@PathVariable String naziv, @PathVariable Long idKalkulacije) {
        System.out.println("naziv: " + naziv + " idKalkulacije: " + idKalkulacije);
        return ResponseEntity.ok(sablonKalkulacijaService.noviSablon(naziv, idKalkulacije));
    }


    @GetMapping("/naziv={naziv}")
    public ResponseEntity<?> pronadjiPoNazivu(@PathVariable String naziv) {
        return ResponseEntity.ok(sablonKalkulacijaService.pronadjiPoNazivu(naziv));
    }
}
