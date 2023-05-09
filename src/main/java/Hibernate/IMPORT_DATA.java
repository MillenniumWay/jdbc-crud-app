package Hibernate;

import Hibernate.Entity.Client;
import Hibernate.Entity.Doctor;
import Hibernate.Entity.Hospital;

import java.sql.Date;

import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class IMPORT_DATA {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
             session.beginTransaction();
             importData(sessionFactory);
             session.close();
        }
    }



    public void importData(@NotNull SessionFactory sessionFactory) {
        @Cleanup Session session = sessionFactory.openSession();
        saveHospital(session, "Hahn Group","Information Services");
        saveHospital(session, "Schmitt-Schmitt","Warehousing");
        saveHospital(session, "Wisoky, Wisoky and Wisoky","Media Production");
        saveHospital(session, "Russel-Russel","Commercial Real Estate");
        saveHospital(session, "Stehr-Stehr","Save Life");

        saveDoctor(session, "Angus", "Hilpert", "Venonat",1);
        saveDoctor(session, "King", "Ernser", "Electrode",2);
        saveDoctor(session, "Paula", "Kutch", "Omanyte",3);
        saveDoctor(session, "Brandi", "Kemmer", "Seadra",4);
        saveDoctor(session, "Joshuah", "Hansen", "Arcanine",5);


        saveClient(session,"Hilpert","Angus","124S3421","A2-42",new Date(01-05-2010),1);
        saveClient(session,"Ernser","Paula","756S3421","B1-52",new Date(10-4-2011),2);
        saveClient(session,"Kutch","Paula","76AS3421","C3-13",new Date(15-03-2012),3);
        saveClient(session,"Kemmer","Brandi","34AS3421","H1-2",new Date(20-02-2013),4);
        saveClient(session,"Hansen","Joshuah","12AS3421","A3-12",new Date(30-01-2014),5);
    }
    private Hospital saveHospital(Session session, String name,String spec) {
        Hospital hospital = Hospital.builder()
                        .nameHospital(name)
                                .specialisation(spec)
                                        .build();
        session.save(hospital);

        return hospital;
    }

    private Doctor saveDoctor(Session session,
                            String firstName,
                            String lastName,
                            String speciality,
                            long hospital_id) {
        Doctor doctor = Doctor.builder()
                .firstName(firstName)
                .lastName(lastName)
                .speciality(speciality)
                .hospitalId(hospital_id)
                .build();
        session.save(doctor);

        return doctor;
    }

    private Client saveClient(Session session,
                              String firstName,
                              String lastName,
                              String pass,
                              String code,
                              Date date,
                              int fk_doc) {

        Client client = Client.builder()
                        .firstName(firstName)
                                .lastName(lastName)
                                        .passportNum(pass)
                                                .codeOfDiagnose(code)
                                                        .dateEntry(date)
                                                                .fkDoctorId(fk_doc)
                                                                        .build();
        session.save(client);
        return client;
    }


}


