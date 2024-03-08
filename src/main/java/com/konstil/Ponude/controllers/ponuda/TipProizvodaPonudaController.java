package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.service.ponuda.TipProizvodaPonudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tip-proizvoda-ponuda")
@CrossOrigin
public class TipProizvodaPonudaController {
    @Autowired
    private TipProizvodaPonudaService tipProizvodaPonudaService;

    @GetMapping("/svi")
    public ResponseEntity<?> getTipProizvodaPonuda() {
        try {
            return ResponseEntity.ok(tipProizvodaPonudaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
