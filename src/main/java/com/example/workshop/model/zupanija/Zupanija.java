package com.example.workshop.model.zupanija;

import com.example.workshop.model.mjesto.Mjesto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="zupanija", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Zupanija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sif_zupanija", unique = true)
    private Long sifZupanija;
    @Column(name="naziv_zupanija")
    private String nazivZupanija;
    @OneToMany(mappedBy="zupanija")
    private List<Mjesto> mjesta;
}
