package com.example.workshop.model.zupanija;

import com.example.workshop.model.mjesto.Mjesto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "sif_zupanija")
    private Long sifZupanija;
    @Column(name="naziv_zupanija")
    private String nazivZupanija;
    @OneToMany(mappedBy="zupanija", fetch = FetchType.EAGER)
    private List<Mjesto> mjesta;
}
