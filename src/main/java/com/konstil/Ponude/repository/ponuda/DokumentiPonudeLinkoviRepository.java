package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.DokumentiPonudeLinkovi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DokumentiPonudeLinkoviRepository extends JpaRepository<DokumentiPonudeLinkovi, Long> {
    List<DokumentiPonudeLinkovi> getByPonudaId(Long idPonude);
}
