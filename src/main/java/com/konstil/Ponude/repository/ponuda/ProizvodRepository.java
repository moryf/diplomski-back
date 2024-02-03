package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, String> {
}
