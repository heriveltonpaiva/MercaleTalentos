CREATE TABLE estado(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  sigla varchar NOT NULL,
  CONSTRAINT estado_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

INSERT INTO estado VALUES (1, 'Acre', 'AC');

CREATE TABLE cidade(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  id_estado integer NOT NULL,
  CONSTRAINT cidade_pk PRIMARY KEY (id),
   CONSTRAINT estado_fk FOREIGN KEY (id_estado)
      REFERENCES estado (id)
)
WITH (
  OIDS=FALSE
);

INSERT INTO cidade VALUES (1, 'Rio Branco', 1);

