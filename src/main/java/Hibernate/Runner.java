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
    public void addToDoctor() {
        @Cleanup Session session = sessionFactory.openSession();
        Doctor addNewDoctor = new Doctor(1,"David","Hibernate", "JavaDev");
        hibernate.hqlAddToDoctorEntity(session, new Doctor(addNewDoctor.getHospitalId(),
                addNewDoctor.getFirstName(),addNewDoctor.getLastName(), addNewDoctor.getSpeciality()));
        session.getTransaction().commit();
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
