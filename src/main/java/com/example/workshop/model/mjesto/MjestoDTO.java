package com.example.workshop.model.mjesto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MjestoDTO {
    private Long pbrMjesto;
    private String nazivMjesto;
    private Long sifZupanija;
}
