package com.konstil.Ponude.service.util;

import com.konstil.Ponude.domain.util.PodrazumevaneVrednosti;
import com.konstil.Ponude.repository.util.PodrazumevaneVrednostiRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;

public class PodrazumevaneVrednostiService extends OpstiService<PodrazumevaneVrednosti,String> {

    @Autowired
    public PodrazumevaneVrednostiService(PodrazumevaneVrednostiRepository podrazumevaneVrednostiRepository) {
        this.repository = podrazumevaneVrednostiRepository;
    }
}
