package Hibernate;

import Hibernate.Entity.Client;
import Hibernate.Entity.Doctor;
import Hibernate.Entity.Hospital;
import Utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Runner {
    private final HibernateDAO hibernate = new HibernateDAO();
    private final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private final Hospital hospital = new Hospital();
    private final Doctor doctor = new Doctor();
    private final Client client = new Client();

    @Test
    public void readAllFromDoctor(){
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlReadFromDoctor(session, doctor);
        session.getTransaction().commit();
    }
    @Test
    public void readAllFromHospital() {
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlAddToHospitalEntity(session, hospital);
        session.getTransaction().commit();

    }
    @Test
    public void  readAllFromClient() {
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlReadFromClient(session, client);
        session.getTransaction().commit();
    }

    @Test
     public void byIdHospital () {
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlReadBuIdHospital(session, 1L);
        session.close();
    }
    @Test
    public void byDoctorId () {
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlReadByIdDoctor(session, 1L);
        session.close();
    }
    @Test
    public void byClientId () {
        @Cleanup Session session = sessionFactory.openSession();
        hibernate.hqlReadByIdClient(session, 1L);
        session.close();
    }

   @Test
     public void addToHospital () {
     @Cleanup Session session = sessionFactory.openSession();
     Hospital addNewHospital = new Hospital("Hibernate","Programming");
     hibernate.hqlAddToHospitalEntity(session, new Hospital(addNewHospital.getNameHospital(), addNewHospital.getSpecialisation()));
     session.close();

}

@Test
public void addToClient () {
    @Cleanup Session session = sessionFactory.openSession();
    Client addNewClient = new Client("David",
            "Frank","324341","A1-F",new Date(10-01-2001),1);
    hibernate.hqlAddToClientEntity(session, new Client(addNewClient.getFirstName(), addNewClient.getLastName(),
            client.getPassportNum(), addNewClient.getCodeOfDiagnose(), addNewClient.getDateEntry(), addNewClient.getFkDoctorId()));
    session.close();
}

    @Test
    public void addToDoctor() {
        @Cleanup Session session = sessionFactory.openSession();
        Doctor addNewDoctor = new Doctor(1,"David","Hibernate", "JavaDev");
        hibernate.hqlAddToDoctorEntity(session, new Doctor(addNewDoctor.getHospitalId(),
                addNewDoctor.getFirstName(),addNewDoctor.getLastName(), addNewDoctor.getSpeciality()));
        session.close();
    }




            public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {

             HibernateDAO hibernate = new HibernateDAO();
             Hospital hospital = new Hospital();
             Doctor doctor = new Doctor();
             Client client = new Client();

             // ANY CODE HERE
             //    hibernate.hqlReadFromClient(session, client);
             //    hibernate.hqlReadFromDoctor(session,doctor);
             //    hibernate.hqlReadFromHospital(session, hospital);

            // ANY CODE HERE


             session.close();
            } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        }
}
