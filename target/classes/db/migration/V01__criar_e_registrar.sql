-- Table: agenda."CONTATO"

-- DROP TABLE agenda."CONTATO";

CREATE TABLE agenda."CONTATO"
(
    nome character(50) COLLATE pg_catalog."default",
    id integer NOT NULL,
    email character(50) COLLATE pg_catalog."default",
    "dataCadastro" date,
    CONSTRAINT "CONTATO_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE agenda."CONTATO"
    OWNER to postgres;
    
-- Table: agenda."TELEFONE"

-- DROP TABLE agenda."TELEFONE";

CREATE TABLE agenda."TELEFONE"
(
    id integer NOT NULL,
    numero integer,
    ddd integer,
    CONSTRAINT "TELEFONE_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE agenda."TELEFONE"
    OWNER to postgres;
