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
    @Column(name="sifzupanija", unique = true)
    private Long sifZupanija;
    @Column(name="nazivzupanija")
    private String nazivZupanija;
    @OneToMany(mappedBy="zupanija")
    private List<Mjesto> mjesta;
}
