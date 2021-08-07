package com.example.workshop.model.zupanija;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ZupanijaDTOPaginated {
    private List<ZupanijaDTO> zupanije;
    private Integer page;
}
