package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.ProizvodPonuda;
import com.konstil.Ponude.service.ponuda.ProizvodPonudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proizvod-ponuda")
@CrossOrigin
public class ProizvodPonudaController {
    @Autowired
    private ProizvodPonudaService proizvodPonudaService;

    @GetMapping("/ponuda/{id}")
    public ResponseEntity<?> getProizvodiPonudaByPonudaId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(proizvodPonudaService.getProizvodiPonudaByPonudaId(id));
    }

    @PostMapping("/ponuda/{id}/dodaj")
    public ResponseEntity<?> dodajProizvodPonuda(@PathVariable("id") Long id, @RequestBody ProizvodPonuda proizvodPonuda) {
        return ResponseEntity.ok(proizvodPonudaService.dodajProizvodPonuda(id, proizvodPonuda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProizvodPonudaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(proizvodPonudaService.findById(id));
    }
}
