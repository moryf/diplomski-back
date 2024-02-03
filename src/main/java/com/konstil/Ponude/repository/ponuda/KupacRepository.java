package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Long> {
}
