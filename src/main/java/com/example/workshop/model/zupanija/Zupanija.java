package com.example.workshop.model.zupanija;

import com.example.workshop.model.mjesto.Mjesto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="zupanija")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Zupanija {

    @Id
    @Column(name="sifzupanija")
    private Long sifZupanija;
    @Column(name="nazivzupanija")
    private String nazivZupanija;
    @OneToMany(mappedBy="mjesto")
    private List<Mjesto> mjesta;
}
