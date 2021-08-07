package com.example.workshop.model.mjesto;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MjestoDTOPaginated {
    private List<MjestoDTO> mjesta;
    private Integer page;
}
