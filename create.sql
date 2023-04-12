CREATE TABLE hospital (
  id_hospital bigserial PRIMARY KEY NOT NULL,
  name_hospital varchar(46) NOT NULL,
  specialisation varchar(46) NOT NULL
);

CREATE TABLE doctor (
    doctor_id bigserial PRIMARY KEY NOT NULL,
    hospital_id bigserial REFERENCES hospital(id_hospital),
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    speciality varchar(32) NOT NULL
);


CREATE TABLE client (
    client_id bigserial PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    passport_num varchar(32),
    code_of_diagnose varchar(16) NOT NULL,
    date_entry date NOT NULL,
    fk_doctor_id SERIAL NOT NULL,
    FOREIGN KEY (fk_doctor_id ) REFERENCES doctor(doctor_id)
);