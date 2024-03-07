package com.konstil.Ponude.service.ponuda;

import com.konstil.Ponude.domain.ponuda.ProizvodPonuda;
import com.konstil.Ponude.exception.ServerException;
import com.konstil.Ponude.repository.ponuda.PonudaRepository;
import com.konstil.Ponude.repository.ponuda.ProizvodPonudaRepository;
import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodPonudaService extends OpstiService<ProizvodPonuda,Long> {
    @Autowired
    public ProizvodPonudaService(ProizvodPonudaRepository proizvodPonudaRepository) {
        this.repository = proizvodPonudaRepository;
    }
    @Autowired
    PonudaRepository ponudaRepository;

    public List<ProizvodPonuda> getProizvodiPonudaByPonudaId(Long id) {
        try {
            return ((ProizvodPonudaRepository)repository).getProizvodPonudasByPonudaId(id);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja proizvoda ponude:"+e.getMessage());
        }
    }

    public ProizvodPonuda dodajProizvodPonuda(Long id, ProizvodPonuda proizvodPonuda) {
        try {
            proizvodPonuda.setPonuda(ponudaRepository.findById(id).get());
            return repository.save(proizvodPonuda);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dodavanja proizvoda ponude:"+e.getMessage());
        }
    }
}
