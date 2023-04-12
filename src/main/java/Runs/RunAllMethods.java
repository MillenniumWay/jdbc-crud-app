package Runs;

import DAO_LAYERS.ClientsDAO;
import DAO_LAYERS.DoctorDAO;
import DAO_LAYERS.HospitalDAO;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.Date;

public class RunAllMethods {

    public static void main(String[] args) throws SQLException {
        HospitalDAO hospitalDAO = new HospitalDAO();
        ClientsDAO clientsDAO = new ClientsDAO();
        DoctorDAO doctorDAO = new DoctorDAO();

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String pokemon  =  faker.pokemon().name();
        String spec = faker.company().industry();
        String nameComp = faker.company().name();
        String fakecode = faker.code().ean8();
        String fakecode2 = faker.code().ean8();
        String VERY_IMPORTANT_INFORMATION = faker.chuckNorris().fact();


        for (int a = 0; a < 10; a++) {
            // INSERT CODE HERE TO DUPLICATE ANY OPTIONS

            // INSERT CODE HERE TO DUPLICATE ANY OPTIONS
        }


        // Добавление больницы
        //  hospitalDAO.insertIntoHospital(nameComp, spec);

        // Добавление доктора // Первым передаваемым параметрам укажите ID больницы к которой привязан врач
        //  doctorDAO.insertIntoDoctor(5, firstName, lastName, pokemon);

        //  Добавление клиента
        //  clientsDAO.insertIntoClients(firstName,lastName,fakecode,fakecode2,"2009-10-10",10);


        // Получить список всех больниц
        //  System.out.println("Select ALL_HOSPITALS:  " +  hospitalDAO.selectAllHospitals());

        // Получить список всех врачей
        //  System.out.println("Select ALL_DOCTORS:  " + doctorDAO.readAllDoctors());

        // Получить список всех клиентов
        //  System.out.println("Select ALL_CLIENTS:  " + clientsDAO.readAllClients());


        // Изменить параметры больницы
        // hospitalDAO.updateHospital(2, new Hospital(firstName, lastName));

        // Изменить параметры доктора
        // doctorDAO.updateDoctorById(12, new Doctor(firstName,lastName,pokemon));

        // Изменить параметры клиента
        // clientsDAO.updateCLientById(15, new Client(firstName,lastName,"code","code","3000-10-01"));


        // Удаление больницы

        // ВНИМАНИЕ   ПРИ УДАЛЕНИИ БУДУТ СТЕРТЫ ДАННЫЕ КЛИЕНТОВ/ВРАЧЕЙ СВЯЗАННЫХ С ДАННОЙ БОЛЬНИЦОЙ  ВНИМАНИЕ //
        //   hospitalDAO.deleteHospital(1);
        // ВНИМАНИЕ   ПРИ УДАЛЕНИИ БУДУТ СТЕРТЫ ДАННЫЕ КЛИЕНТОВ/ВРАЧЕЙ СВЯЗАННЫХ С ДАННОЙ БОЛЬНИЦОЙ  ВНИМАНИЕ //

        // Удаление клиента
        //  clientsDAO.deleteFromClient(13)

        // Удаление доктора
        // doctorDAO.deleteFromDoctor(20);


        // Полное удаление врачей / клиентов
        //  doctorDAO.truncateTable();

        //  Полное удаление врачей / клиентов / больниц
        //  hospitalDAO.turncateFromHospital();


        System.out.println(VERY_IMPORTANT_INFORMATION);
    }

}

