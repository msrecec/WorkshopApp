package com.example.workshop.model.zupanija;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ZupanijaCommand {
    @NotNull(message = "Sifra zupanije must not be null")
    @PositiveOrZero(message = "Sifra zupanije must be greater than or equal to zero")
    private Long sifZupanija;
    @NotBlank(message = "Naziv zupanije must not be empty")
    @NotNull(message = "Naziv zupanije must not be null")
    @Size(min = 3, max = 50, message = "Zupanija must be higher than 3 or smaller than 50")
    private String nazivZupanija;
}
