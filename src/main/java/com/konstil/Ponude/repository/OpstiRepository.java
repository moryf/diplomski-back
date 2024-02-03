package com.konstil.Ponude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface OpstiRepository<T,ID> extends JpaRepository<T, ID> {
}
