package com.example.workshop.model.zupanija;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ZupanijaDTO {

    private String nazivZupanija;
}
