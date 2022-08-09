-- Database: waterMeDB

-- DROP DATABASE IF EXISTS "waterMeDB";

CREATE DATABASE "waterMeDB"
    WITH
    OWNER = "waterMe"
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- Table: public.irrigation

-- DROP TABLE IF EXISTS public.irrigation;

CREATE TABLE IF NOT EXISTS public.irrigation
(
    id bigint NOT NULL DEFAULT nextval('irrigation_id_seq'::regclass),
    amount integer,
    date date,
    plant_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT irrigation_pkey PRIMARY KEY (id),
    CONSTRAINT fk4f6t2b8k9uqmcqbmyj5b9bm9n FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkhrobj88i416p1nnjtsg7p4ob7 FOREIGN KEY (plant_id)
    REFERENCES public.plant (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.irrigation
    OWNER to "waterMe";


-- Table: public.issue

-- DROP TABLE IF EXISTS public.issue;

CREATE TABLE IF NOT EXISTS public.issue
(
    id bigint NOT NULL DEFAULT nextval('issue_id_seq'::regclass),
    date date,
    description character varying(255) COLLATE pg_catalog."default",
    picture bytea,
    plant_id bigint NOT NULL,
    CONSTRAINT issue_pkey PRIMARY KEY (id),
    CONSTRAINT fk8i5b4ggqtnwm1u0yw57cdghxg FOREIGN KEY (plant_id)
    REFERENCES public.plant (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.issue
    OWNER to "waterMe";

-- Table: public.plant

-- DROP TABLE IF EXISTS public.plant;

CREATE TABLE IF NOT EXISTS public.plant
(
    id bigint NOT NULL DEFAULT nextval('plant_id_seq'::regclass),
    floor integer,
    icon character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    room character varying(255) COLLATE pg_catalog."default",
    soil_changed date,
    wiki_link character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT plant_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.plant
    OWNER to "waterMe";

-- Table: public.plant_sponsor

-- DROP TABLE IF EXISTS public.plant_sponsor;

CREATE TABLE IF NOT EXISTS public.plant_sponsor
(
    id bigint NOT NULL DEFAULT nextval('plant_sponsor_id_seq'::regclass),
    plant_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT plant_sponsor_pkey PRIMARY KEY (id),
    CONSTRAINT fkd1pil9e6qi3aobsv4xbkjb2we FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkmep4wjp8y7sx0j41pc8hyqogq FOREIGN KEY (plant_id)
    REFERENCES public.plant (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.plant_sponsor
    OWNER to "waterMe";

-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    image bytea,
    CONSTRAINT users_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to "waterMe";
