package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.TipProizvodaPonuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipProizvodaPonudaRepository extends JpaRepository<TipProizvodaPonuda, Long> {
}
