package com.konstil.Ponude.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IzmenaSifreRequest {
    String staraSifra;
    String novaSifra;
}
