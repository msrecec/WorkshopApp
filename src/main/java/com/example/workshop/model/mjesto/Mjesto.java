package com.example.workshop.model.mjesto;


import com.example.workshop.model.zupanija.Zupanija;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;

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
    @Column(name = "pbr_mjesto")
    private Long pbrMjesto;
    @Column(name="naziv_mjesto")
    private String nazivMjesto;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sif_zupanija")
    @JsonIgnore
    private Zupanija zupanija;
}
