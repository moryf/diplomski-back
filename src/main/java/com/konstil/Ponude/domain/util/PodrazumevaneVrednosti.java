package com.konstil.Ponude.domain.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PodrazumevaneVrednosti {
    @Id
    String oznaka;
    @Column(nullable = false)
    float vrednost;
}
