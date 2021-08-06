package com.example.workshop.model.zupanija;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private Integer sifZupanija;
    @Column(name="nazivzupanija")
    private String nazivZupanija;
}
