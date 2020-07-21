DROP TABLE provincia;
CREATE TABLE provincia
(   id_provincia NUMBER NOT NULL PRIMARY KEY,
    nome VARCHAR2(30) NOT NULL,
    sigla VARCHAR2(5) NOT NULL,
    regione VARCHAR2(30) NOT NULL
);

--data load da file csv

--comuni-pre contiene i dati direttamente dal csv
CREATE TABLE comuni_pre
(   id_comune NUMBER NOT NULL PRIMARY KEY,
    nome_comune VARCHAR2(100) NOT NULL,
    provincia VARCHAR2(30) NOT NULL    
);

--comuni è la tabella vera e propria, con la foreign key che la collega a province

CREATE TABLE comune
(   id_comune NUMBER NOT NULL PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    id_provincia NUMBER NOT NULL,
    FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

--popolo comuni con dati da comuni_pre sostituendo la provincia con l'id corrispondente

INSERT INTO comune 
SELECT id_comune, nome_comune, id_provincia
FROM comuni_pre INNER JOIN provincia
ON comuni_pre.provincia = provincia.nome;
COMMIT;

--tabella anagrafica

CREATE TABLE anagrafica
(   id_anagrafica NUMBER NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL,
    num_civico NUMBER NOT NULL,
    comune VARCHAR2(100) NOT NULL,
    id_comune NUMBER NOT NULL,
    provincia VARCHAR2(30) NOT NULL,
    id_provincia NUMBER NOT NULL,
    FOREIGN KEY (id_comune) REFERENCES comune(id_comune),
    FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);



INSERT INTO anagrafica(nome, cognome, indirizzo, num_civico, id_comune, id_provincia)
VALUES ('Joe','Pesce','Via Le dita dal naso',3,2,49);





