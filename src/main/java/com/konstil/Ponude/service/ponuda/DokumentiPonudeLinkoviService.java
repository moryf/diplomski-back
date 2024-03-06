package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.DokumentiPonudeLinkovi;
import com.konstil.Ponude.repository.ponuda.DokumentiPonudeLinkoviRepository;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DokumentiPonudeLinkoviService extends OpstiService<DokumentiPonudeLinkovi,Long> {

    @Autowired
    public DokumentiPonudeLinkoviService(DokumentiPonudeLinkoviRepository repository) {
        this.repository = repository;
    }
    @Autowired
    PonudaRepository ponudaRepository;

    public List<DokumentiPonudeLinkovi> getByPonudaId(Long idPonude) {
        return ((DokumentiPonudeLinkoviRepository)repository).getByPonudaId(idPonude);
    }

    public DokumentiPonudeLinkovi noviDokument(Long idPonude, DokumentiPonudeLinkovi dokumentiPonudeLinkovi) {
        dokumentiPonudeLinkovi.setPonuda(ponudaRepository.findById(idPonude).get());
        return repository.save(dokumentiPonudeLinkovi);
    }
}
