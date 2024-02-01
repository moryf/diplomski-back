package com.konstil.Ponude.repository;

import com.konstil.Ponude.domain.Ponuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
}
