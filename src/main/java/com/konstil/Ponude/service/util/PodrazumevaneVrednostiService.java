package com.konstil.Ponude.service.util;

import com.konstil.Ponude.domain.util.PodrazumevaneVrednosti;
import com.konstil.Ponude.repository.util.PodrazumevaneVrednostiRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodrazumevaneVrednostiService extends OpstiService<PodrazumevaneVrednosti,String> {

    @Autowired
    public PodrazumevaneVrednostiService(PodrazumevaneVrednostiRepository podrazumevaneVrednostiRepository) {
        this.repository = podrazumevaneVrednostiRepository;
    }

    public PodrazumevaneVrednosti update(String oznaka, float vrednost) {
        PodrazumevaneVrednosti podrazumevaneVrednosti = findById(oznaka);
        podrazumevaneVrednosti.setVrednost(vrednost);
        return save(podrazumevaneVrednosti);
    }
}
