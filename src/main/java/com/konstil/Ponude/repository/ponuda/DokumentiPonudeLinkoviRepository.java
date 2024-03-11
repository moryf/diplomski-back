package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.DokumentiPonudeLinkovi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DokumentiPonudeLinkoviRepository extends JpaRepository<DokumentiPonudeLinkovi, Long> {
    List<DokumentiPonudeLinkovi> getByPonudaId(Long idPonude);
}
