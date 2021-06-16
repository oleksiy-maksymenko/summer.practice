CREATE TABLE working_place
(
    id integer NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    created_at character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    updated_at character varying(255) COLLATE pg_catalog."default",
    updated_by character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT working_place_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE working_place
    OWNER to postgres;

CREATE TABLE pc
(
    cpu_count integer,
    created_at character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    hdd_size integer,
    height double precision,
    length double precision,
    updated_at character varying(255) COLLATE pg_catalog."default",
    updated_by character varying(255) COLLATE pg_catalog."default",
    width double precision,
    place_id integer NOT NULL,
    CONSTRAINT pc_pkey PRIMARY KEY (place_id),
    CONSTRAINT fkjehqlo661ck8r1rqf43625qw FOREIGN KEY (place_id)
        REFERENCES public.working_place (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE pc
    OWNER to postgres;

CREATE TABLE monitor
(
    id integer NOT NULL,
    created_at character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    display_size double precision,
    height double precision,
    length double precision,
    updated_at character varying(255) COLLATE pg_catalog."default",
    updated_by character varying(255) COLLATE pg_catalog."default",
    width double precision,
    place_id integer,
    CONSTRAINT monitor_pkey PRIMARY KEY (id),
    CONSTRAINT fkh7ixtdn72435017nvrg6i9f8h FOREIGN KEY (place_id)
        REFERENCES working_place (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE monitor
    OWNER to postgres;