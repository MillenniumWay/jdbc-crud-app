package Hibernate;

import Hibernate.Entity.Client;
import Hibernate.Entity.Doctor;
import Hibernate.Entity.Hospital;
import org.hibernate.Session;

import java.security.spec.ECField;
import java.sql.Date;

public class HibernateDAO {
    public void hqlAddToClientEntity (Session session, Hospital hospital) {
        try {
            session.beginTransaction();
            Date today = new Date(10-10-2000);
            var obj = Client.builder()
                            .firstName("Client")
                                    .lastName("CLient")
                                            .passportNum("Puss")
                                                    .codeOfDiagnose("Code")
                                                            .dateEntry(today)
                                                                    .fkDoctorId(3)
                    .build();
            session.save(obj);
            session.close();
        } catch (Exception exception) {exception.printStackTrace();}
    }
    public void hqlAddToHospitalEntity (Session session, Hospital hospital) {
        try {
            session.beginTransaction();
            var obj = Hospital.builder()
                    .nameHospital(hospital.getNameHospital())
                    .specialisation(hospital.getSpecialisation())
                    .build();
            session.save(obj);
            session.close();
        } catch (Exception exception) {exception.printStackTrace();}
    }

    public void hqlAddToDoctorEntity (Session session, Doctor doctor) {
        try {
            session.beginTransaction();
            var obj = Doctor.builder()
                    .doctor_id(doctor.getDoctor_id())
                    .firstName(doctor.getFirstName())
                    .lastName(doctor.getLastName())
                    .speciality(doctor.getSpeciality())
                    .build();
            session.save(obj);
            session.close();
        } catch (Exception exception) { exception.printStackTrace(); }
    }
}
