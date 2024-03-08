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
        try {
            return ResponseEntity.ok(ponudaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nezavrsene")
    public ResponseEntity<?> novePonude() {
        try {
            return ResponseEntity.ok(ponudaService.findNezavrsene());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/prihvacene")
    public ResponseEntity<?> prihvacenePonude() {
        try {
            return ResponseEntity.ok(ponudaService.findByStatus(PonudaStatus.PRIHVACENA));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/odbijene")
    public ResponseEntity<?> odbijenePonude() {
        try {
            return ResponseEntity.ok(ponudaService.findByStatus(PonudaStatus.ODBIJENA));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> ponuda(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ponudaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/prihvati/{id}")
    public ResponseEntity<?> prihvatiPonudu(@PathVariable Long id) {
        try {
            System.out.println("prihvatiPonudu");
            return ResponseEntity.ok(ponudaService.promeniStatus(id, PonudaStatus.PRIHVACENA));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/odbij/{id}")
    public ResponseEntity<?> odbijPonudu(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ponudaService.promeniStatus(id, PonudaStatus.ODBIJENA));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard() {
        try {
            return ResponseEntity.ok(ponudaService.dashboard());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
