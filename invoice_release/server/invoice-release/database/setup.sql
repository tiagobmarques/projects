create table contact (
  id integer not null AUTO_INCREMENT,
  name varchar(200) not null,
  CONSTRAINT contact_id_pk PRIMARY KEY (id)
);

create table user (
  id integer not null AUTO_INCREMENT,
  contact_id integer not null,
  login varchar(50) not null,
  password varchar(50) not null,
  CONSTRAINT user_id_pk PRIMARY KEY (id),
  CONSTRAINT user_contact_id_fk FOREIGN KEY (contact_id) references contact (id)
);

create table participant (
  id integer not null AUTO_INCREMENT,
  contact_id integer not null,
  registration_type varchar(50) not null,
  registration_number varchar(50) not null,
  CONSTRAINT participant_id_pk PRIMARY KEY (id),
  CONSTRAINT participant_contact_id_fk FOREIGN KEY (contact_id) references contact (id)
);

create table invoice (
  id integer not null AUTO_INCREMENT,
  participant_id integer not null,
  installment_date date not null,
  document varchar(14) not null,
  value numeric(13,2) not null,
  CONSTRAINT invoice_id_pk PRIMARY KEY (id),
  CONSTRAINT invoice_participant_id_fk FOREIGN KEY (participant_id) references participant (id)
);