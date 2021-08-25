DROP TABLE IF EXISTS zupanija;

CREATE TABLE zupanija (
                          sif_zupanija INT,
                          naziv_zupanija VARCHAR(50) NOT NULL,
                          PRIMARY KEY (sif_zupanija),
                          UNIQUE (naziv_zupanija)
);

DROP TABLE IF EXISTS mjesto;

CREATE TABLE mjesto (
    pbr_mjesto INT,
    naziv_mjesto VARCHAR(255),
    sif_zupanija INT,
    PRIMARY KEY(pbr_mjesto),
    UNIQUE(naziv_mjesto),
    constraint fk_zupanija foreign key(sif_zupanija) references zupanija(sif_zupanija)
);