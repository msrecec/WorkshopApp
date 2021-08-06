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
    @Column(name="pbrmjesto", unique = true)
    private Long pbrMjesto;
    @Column(name="nazivmjesto", unique = true)
    private String nazivMjesto;
    @ManyToOne
    @JoinColumn(name="sifzupanija")
    private Zupanija zupanija;
}
