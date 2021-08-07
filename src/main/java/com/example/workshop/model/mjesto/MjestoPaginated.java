package com.example.workshop.model.mjesto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MjestoPaginated {
    private List<Mjesto> mjesta;
    private Integer page;
}
