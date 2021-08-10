package com.example.workshop.model.mjesto;


import com.example.workshop.model.zupanija.Zupanija;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="mjesto", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Mjesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pbr_mjesto", unique = true)
    private Long pbrMjesto;
    @Column(name="naziv_mjesto", unique = true)
    private String nazivMjesto;
    @ManyToOne
    @JoinColumn(name="sif_zupanija")
    private Zupanija zupanija;
}
