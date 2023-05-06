package Hibernate;

import Hibernate.Entity.Client;
import Hibernate.Entity.Doctor;
import Hibernate.Entity.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {

             Hospital hospital = new Hospital();
             Doctor doctor = new Doctor();
             Client client = new Client();

             // ANY CODE HERE



            // ANY CODE HERE


             session.close();
            } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        }
}
