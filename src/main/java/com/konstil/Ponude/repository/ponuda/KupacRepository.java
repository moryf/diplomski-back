package com.konstil.Ponude.repository.ponuda;

import com.konstil.Ponude.domain.ponuda.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Long> {
    @Query("SELECT k FROM Kupac k WHERE k.imeIPrezime LIKE %?1% AND k.brojTelefona LIKE %?2%")
    List<Kupac> pretraziKupce(String imeIPrezime, String brojTelefona);
}
