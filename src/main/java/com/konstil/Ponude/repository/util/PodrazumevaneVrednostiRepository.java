package com.konstil.Ponude.repository.util;

import com.konstil.Ponude.domain.util.PodrazumevaneVrednosti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodrazumevaneVrednostiRepository extends JpaRepository<PodrazumevaneVrednosti, String> {
}
