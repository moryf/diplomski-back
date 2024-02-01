package com.konstil.Ponude.repository;

import com.konstil.Ponude.domain.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProizvodRepository extends JpaRepository<Proizvod, String> {
}
