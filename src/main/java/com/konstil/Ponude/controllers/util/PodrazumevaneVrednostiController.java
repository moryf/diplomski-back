package com.konstil.Ponude.controllers.util;

import com.konstil.Ponude.service.util.PodrazumevaneVrednostiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/podrazumevane-vrednosti")
@CrossOrigin
public class PodrazumevaneVrednostiController {
    @Autowired
    PodrazumevaneVrednostiService podrazumevaneVrednostiService;

    @GetMapping("/sve")
    public ResponseEntity<?> vratiSve() {
        return ResponseEntity.ok(podrazumevaneVrednostiService.findAll());
    }


}
