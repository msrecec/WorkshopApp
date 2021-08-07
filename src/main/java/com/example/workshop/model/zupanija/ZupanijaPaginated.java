package com.example.workshop.model.zupanija;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ZupanijaPaginated {
    private List<Zupanija> zupanije;
    private Integer page;
}
