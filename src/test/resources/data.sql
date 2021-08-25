DELETE FROM zupanija;
DELETE FROM mjesto;

INSERT INTO zupanija(sif_zupanija, naziv_zupanija) VALUES
    (1, 'Test zupanija');

INSERT INTO mjesto(pbr_mjesto, naziv_mjesto, sif_zupanija) VALUES
    (1, 'Test mjesto', 1);
