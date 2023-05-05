package Hibernate;

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
//            var obj = session.get(Doctor.class, 1L).getFirstName();
//            var elseq = session.createQuery("SELECT d.firstName, d.lastName FROM Doctor d", Doctor.class).list();
//            for (Doctor list : elseq) {
//                System.out.println(list.toString());
//            }   Date today = new Date();
               HibernateDAO hibernateDAO = new HibernateDAO();
           //  hibernateDAO.hqlInsertIntoDoctor(session, new Doctor(3L,"Ann","Sprite","IT"));
//            hibernateDAO.hqlINSERT_INTO_HOSPITAL(session, Hospital.builder().idHospital(8L).nameHospital("s").specialisation("s").build());
            }

        }
}
