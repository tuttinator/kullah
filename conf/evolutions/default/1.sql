# Tasks schema
 
# --- !Ups

CREATE SEQUENCE colour_id_seq;
CREATE TABLE colour (
    id integer NOT NULL DEFAULT nextval('colour_id_seq'),
    name varchar(255),
    hex varchar(255)
);
 
# --- !Downs
 
DROP TABLE colour;
DROP SEQUENCE colour_id_seq;