package com.example.workshop.model.mjesto;


import com.example.workshop.model.zupanija.ZupanijaDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MjestoDTO {
    private Long pbrMjesto;
    private String nazivMjesto;
    private ZupanijaDTO zupanijaDTO;
}
