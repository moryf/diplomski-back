package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.ProizvodPonuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodPonudaRepository extends JpaRepository<ProizvodPonuda, Long> {
}
