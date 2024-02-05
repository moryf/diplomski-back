package com.konstil.Ponude.repository.kalkulacija;

import com.konstil.Ponude.domain.kalkulacija.FiksniTrosak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiksniTrosakRepository extends JpaRepository<FiksniTrosak, Long> {
}
