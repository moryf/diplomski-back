package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import com.konstil.Ponude.service.ponuda.PonudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ponuda")
@CrossOrigin
public class PonudaController {

    @Autowired
    private PonudaService ponudaService;

    @PostMapping("/dodaj")
    public ResponseEntity<?> dodajPonudu(@RequestBody Ponuda ponuda) {
        try {
            return ResponseEntity.ok(ponudaService.novaPonuda(ponuda));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/sve")
    public ResponseEntity<?> svePonude() {
        return ResponseEntity.ok(ponudaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ponuda(@PathVariable Long id) {
        return ResponseEntity.ok(ponudaService.findById(id));
    }



}
