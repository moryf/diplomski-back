package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.DokumentiPonudeLinkovi;
import com.konstil.Ponude.service.ponuda.DokumentiPonudeLinkoviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dokumenti-ponude-linkovi")
@CrossOrigin
public class DokumentiPonudeLinkoviController {
    @Autowired
    DokumentiPonudeLinkoviService dokumentiPonudeLinkoviService;

    @GetMapping("/ponuda/{idPonude}")
    public ResponseEntity<?> getByPonudaId(@PathVariable Long idPonude) {
        return ResponseEntity.ok(dokumentiPonudeLinkoviService.getByPonudaId(idPonude));
    }

    @PostMapping("/ponuda/{idPonude}")
    public ResponseEntity<?> save(@PathVariable Long idPonude, @RequestBody DokumentiPonudeLinkovi dokumentiPonudeLinkovi) {
        return ResponseEntity.ok(dokumentiPonudeLinkoviService.noviDokument(idPonude, dokumentiPonudeLinkovi));
    }
}
