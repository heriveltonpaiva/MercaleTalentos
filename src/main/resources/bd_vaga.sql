CREATE TABLE cargo
(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  CONSTRAINT cargo_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cargo
  OWNER TO postgres;
  
  CREATE TABLE setor
(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  CONSTRAINT setor_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE setor
  OWNER TO postgres;
  
 CREATE TABLE etapa
(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  CONSTRAINT etapa_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE etapa
  OWNER TO postgres;

CREATE TABLE ramo
(
  id integer NOT NULL,
  descricao varchar NOT NULL,
  CONSTRAINT ramo_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ramo
  OWNER TO postgres;
  
  CREATE TABLE vaga
(
  id integer NOT NULL,
  codigo character NOT NULL,
  descricao character NOT NULL,
  salario NUMERIC NOT NULL,
  carga_horaria INTEGER NOT NULL,
  data_inicio timestamp with time zone NOT NULL,
  data_final timestamp with time zone NOT NULL,
  data_cadastro timestamp with time zone NOT NULL,
  vaga_aberta boolean,
  observacao varchar,
  id_cargo integer NOT NULL,
  id_setor integer NOT NULL,
  id_etapa integer NOT NULL,
  CONSTRAINT vaga_pk PRIMARY KEY (id),
  CONSTRAINT cargo_fk FOREIGN KEY (id_cargo)
      REFERENCES cargo (id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT setor_fk FOREIGN KEY (id_setor)
      REFERENCES setor (id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT etapa_fk FOREIGN KEY (id_etapa)
      REFERENCES etapa (id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL
)
WITH (
  OIDS=FALSE
);

  
  