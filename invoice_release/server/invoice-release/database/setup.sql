create table contact (
  id integer not null,
  name varchar(200) not null,
  CONSTRAINT contact_id_pk PRIMARY KEY (id)
);

create table user (
  id integer not null,
  contact_id integer not null,
  login varchar(50) not null,
  password varchar(50) not null,
  CONSTRAINT user_id_pk PRIMARY KEY (id),
  CONSTRAINT contact_id_fk FOREIGN KEY (contact_id) references contact (id)
);
