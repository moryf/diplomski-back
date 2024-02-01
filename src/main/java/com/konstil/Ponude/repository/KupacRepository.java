package com.konstil.Ponude.repository;

import com.konstil.Ponude.domain.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository<Kupac, Long> {
}
