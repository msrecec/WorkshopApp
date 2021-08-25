package com.example.workshop.model.mjesto;

import com.example.workshop.model.zupanija.ZupanijaCommand;
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
public class MjestoCommand {
    @NotNull(message = "pbrMjesto zupanije must not be null")
    @PositiveOrZero(message = "pbrMjesto must be greater than or equal to zero")
    private Long pbrMjesto;
    @NotBlank(message = "Naziv mjesta must not be empty")
    @NotNull(message = "Naziv mjesta must not be null")
    @Size(min = 3, max = 50, message = "Naziv mjesta must be higher than 3 or smaller than 50")
    private String nazivMjesto;
    private ZupanijaCommand zupanijaCommand;
}
