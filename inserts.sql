INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (1, 'Hahn Group', 'Sports');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (2, 'Schmitt-Schmitt', 'Museums and Institutions');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (3, 'Wisoky, Wisoky and Wisoky', 'Information Services');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (4, 'Russel-Russel', 'Glass, Ceramics & Concrete');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (5, 'Terry, Terry and Terry', 'Warehousing');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (6, 'Sporer, Sporer and Sporer', 'Media Production');
INSERT INTO hospital (id_hospital, name_hospital, specialisation) VALUES (7, 'Stehr-Stehr', 'Commercial Real Estate');

INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (1, 1, 'Angus', 'Hilpert', 'Flareon');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (2, 1, 'King', 'Ernser', 'Abra');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (3, 2, 'Paula', 'King', 'Venonat');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (4, 2, 'Brandi', 'Kutch', 'Rhydon');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (5, 3, 'Joshuah', 'Kessler', 'Electrode');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (6, 3, 'Florence', 'Kemmer', 'Flareon');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (7, 4, 'Keely', 'Schmitt', 'Omanyte');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (8, 4, 'Bradley', 'Labadie', 'Aerodactyl');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (9, 5, 'Andrew', 'Hansen', 'Seadra');
INSERT INTO doctor (doctor_id, hospital_id, first_name, last_name, speciality) VALUES (10, 5, 'Green', 'Kuphal', 'Arcanine');


INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (1, 'Margaretta', 'Price', '59510611', '67887606', '2000-10-10', 1);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (2, 'Zoie', 'Stamm', '23982802', '27672419', '2001-10-10', 1);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (3, 'Abraham', 'Brakus', '59130758', '99058173', '2002-10-10', 2);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (4, 'Einar', 'Donnelly', '66979784', '00880046', '2003-10-10', 2);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (5, 'Eduardo', 'Kulas', '02603827', '13622411', '2004-10-10', 3);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (6, 'Jennings', 'Ortiz', '67238392', '50805525', '2005-10-10', 3);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (7, 'Rey', 'King', '20583736', '68055752', '2006-10-10', 4);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (8, 'Marlene', 'Gulgowski', '35028635', '40920245', '2007-10-10', 4);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (9, 'Alexander', 'Will', '05730094', '59634140', '2008-10-10', 5);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (10, 'Rogers', 'Goodwin', '50582945', '30986459', '2009-10-10', 5);
INSERT INTO client (client_id, first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) VALUES (11, 'Quentin', 'Zboncak', '71292236', '89277355', '2009-10-10', 6);
