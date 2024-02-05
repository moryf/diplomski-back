package com.konstil.Ponude.controllers.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import com.konstil.Ponude.service.ponuda.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proizvod")
public class ProizvodController {

    @Autowired
    ProizvodService proizvodService;

    @GetMapping("/all")
    public List<Proizvod> getAllProizvodi() {
        return proizvodService.findAll();
    }
}
