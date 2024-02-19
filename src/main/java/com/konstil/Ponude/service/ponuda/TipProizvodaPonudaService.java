package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.TipProizvodaPonuda;
import com.konstil.Ponude.repository.ponuda.TipProizvodaPonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipProizvodaPonudaService extends OpstiService<TipProizvodaPonuda,Long> {
    @Autowired
    public TipProizvodaPonudaService(TipProizvodaPonudaRepository tipProizvodaPonudaRepository) {
        this.repository = tipProizvodaPonudaRepository;
    }
}
