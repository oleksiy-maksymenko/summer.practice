
create sequence user_sequence start 1 increment 1;

CREATE TABLE IF NOT EXISTS working_place
(
    id integer NOT NULL,
    city character varying(255),
    created_at character varying(255),
    created_by character varying(255),
    name character varying(255),
    updated_at character varying(255),
    updated_by character varying(255),
    CONSTRAINT working_place_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pc
(
    id integer NOT NULL,
    cpu_count integer,
    created_at character varying(255),
    created_by character varying(255),
    hdd_size integer,
    height double precision,
    length double precision,
    updated_at character varying(255),
    updated_by character varying(255),
    width double precision,
    place_id integer NOT NULL,
    CONSTRAINT pc_pkey PRIMARY KEY (id),
    CONSTRAINT fk FOREIGN KEY (place_id)
        REFERENCES working_place (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS monitor
(
    id integer NOT NULL,
    created_at character varying(255),
    created_by character varying(255),
    display_size double precision,
    height double precision,
    length double precision,
    updated_at character varying(255),
    updated_by character varying(255),
    width double precision,
    place_id integer,
    CONSTRAINT monitor_pkey PRIMARY KEY (id),
    CONSTRAINT fk FOREIGN KEY (place_id)
        REFERENCES working_place (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
