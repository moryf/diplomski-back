package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
    List<Ponuda> findByStatus(PonudaStatus ponudaStatus);

    @Query(
        value = "SELECT COUNT(*) FROM ponude WHERE status = 'NOVA' AND rok_ponude < current_date + 7 AND rok_ponude > current_date",
            nativeQuery = true
    )
    int ponudeSaRokomOveNedelje();

    @Query(
        value = "SELECT COUNT(*) FROM ponude WHERE status = 'NOVA' AND rok_ponude < current_date",
            nativeQuery = true
    )
    int ponudeSaIsteklimRokom();

    @Query(
        value = "SELECT COUNT(*) FROM ponude WHERE status = 'NOVA' AND datum_otvaranja > current_date - 7",
            nativeQuery = true
    )
    int novihPonudaOveNedelje();
}
