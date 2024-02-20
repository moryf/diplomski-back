package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import com.konstil.Ponude.domain.ponuda.PonudaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
    List<Ponuda> findByStatus(PonudaStatus ponudaStatus);
}
