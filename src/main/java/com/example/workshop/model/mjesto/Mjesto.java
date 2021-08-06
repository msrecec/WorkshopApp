package com.example.workshop.model.mjesto;


import com.example.workshop.model.zupanija.Zupanija;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="mjesto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Mjesto {

    @Id
    @Column(name="pbrmjesto")
    private Long pbrMjesto;
    @Column(name="nazivmjesto")
    private String nazivMjesto;
    @Column(name="sifzupanija")
    private Long sifZupanija;
    @ManyToOne
    private Zupanija zupanija;
}
