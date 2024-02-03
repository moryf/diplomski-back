package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Ponuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
}
