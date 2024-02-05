package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;

public class PonudaService extends OpstiService<Ponuda,Long> {
    @Autowired
    public PonudaService(PonudaRepository ponudaRepository) {
        this.repository = ponudaRepository;
    }
}
