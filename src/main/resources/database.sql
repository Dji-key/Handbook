CREATE TABLE records (
  id serial PRIMARY KEY ,
  name VARCHAR(50) NOT NULL ,
  vkRef VARCHAR(50) ,
  fbRef VARCHAR(50),
  skype VARCHAR(50),
  telegram VARCHAR(50),
  whatsapp VARCHAR(50)
);

CREATE TABLE phones (
  id serial PRIMARY KEY ,
  number VARCHAR (20)
);

CREATE TABLE record_phone (
  rec_id integer NOT NULL ,
  phone_id integer NOT NULL ,
  PRIMARY KEY (rec_id, phone_id),
  CONSTRAINT rec_id_fkey FOREIGN KEY (rec_id) REFERENCES records (id) MATCH SIMPLE ON DELETE CASCADE ON UPDATE CASCADE ,
  CONSTRAINT phone_id_fkey FOREIGN KEY (phone_id) REFERENCES phones (id) MATCH SIMPLE ON DELETE CASCADE ON UPDATE CASCADE
);