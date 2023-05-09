package Hibernate;

import Hibernate.Entity.Client;
import Hibernate.Entity.Doctor;
import Hibernate.Entity.Hospital;
import org.hibernate.Session;
import org.junit.Test;


import java.sql.Date;

public class HibernateDAO {


    public Hospital hqlReadFromHospital(Session session, Hospital hospital) {
        try {
            session.beginTransaction();
          var var_hospital =  session.createQuery("FROM Hospital", Hospital.class).list();
              for (Hospital hospital1: var_hospital) {
                System.out.println(hospital1.toString());
              }
        } catch (Exception e) {e.printStackTrace();}
    return hospital;
    }


    public Doctor hqlReadFromDoctor(Session session, Doctor doctor) {
        try {
            session.beginTransaction();
            var var_doctor =  session.createQuery("FROM Doctor", Doctor.class).list();
            for (Doctor doctor1: var_doctor) {
                System.out.println(doctor1.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
        return doctor;
    }

    public Client hqlReadFromClient(Session session, Client client) {
        try {
            session.beginTransaction();
            var var_client =  session.createQuery("FROM Client", Client.class).list();
            for (Client client1: var_client) {
                System.out.println(client1.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
        return client;
    }




    public void hqlAddToClientEntity (Session session, Client client) {
        try {
            session.beginTransaction();
            Date today = new Date(10-10-2000);
            var obj = Client.builder()
                            .firstName(client.getFirstName())
                                    .lastName(client.getLastName())
                                            .passportNum(client.getPassportNum())
                                                    .codeOfDiagnose(client.getCodeOfDiagnose())
                                                            .dateEntry(client.getDateEntry())
                                                                    .fkDoctorId(client.getFkDoctorId())
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
