package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.ProizvodPonuda;
import com.konstil.Ponude.repository.ponuda.ProizvodPonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProizvodPonudaService extends OpstiService<ProizvodPonuda,Long> {
    @Autowired
    public ProizvodPonudaService(ProizvodPonudaRepository proizvodPonudaRepository) {
        this.repository = proizvodPonudaRepository;
    }
}
