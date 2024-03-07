package com.konstil.Ponude.service.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.FiksniTrosak;
import com.konstil.Ponude.repository.kalkulacija.FiksniTrosakRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiksniTrosakService extends OpstiService<FiksniTrosak,Long> {
    @Autowired
    public FiksniTrosakService(FiksniTrosakRepository fiksniTrosakRepository) {
        this.repository = fiksniTrosakRepository;
    }
}
