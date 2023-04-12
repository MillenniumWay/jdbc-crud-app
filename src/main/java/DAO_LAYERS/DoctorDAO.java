package DAO_LAYERS;
import Connection.ConnectionManager;
import Models.Doctor;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private final String INSERT_INTO_DOCTOR = "INSERT INTO doctor (hospital_id, first_name,last_name,speciality) "
            + "VALUES(?,?,?,?)";
    private final String READ_ALL_FROM_DOCTOR = "SELECT * FROM doctor";
    private final String DELETE_FROM_DOCTOR_BY_ID = "DELETE FROM doctor WHERE doctor_id =?";
    private final String UPDATE_DOCTOR_BY_ID = "UPDATE doctor SET first_name =?, last_name =?, speciality =?  WHERE doctor_id=?;";

    private final String TRUNCATE_DOCTOR_TABLE = "TRUNCATE TABLE doctor CASCADE";

    protected Connection getConnection() throws RuntimeException, SQLException {
      Connection connection;
        try{
             connection = ConnectionManager.open();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  connection;
    }

    public void insertIntoDoctor(int hospital_id,  String first_name,
                                  String last_name, String speciality) throws SQLException {

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_DOCTOR);
            preparedStatement.setInt(1,hospital_id);
            preparedStatement.setString(2,first_name);
            preparedStatement.setString(3,last_name);
            preparedStatement.setString(4,speciality);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> readAllDoctors () throws  SQLException{
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_FROM_DOCTOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int doctor_id = resultSet.getInt("doctor_id");
                int hospital_id = resultSet.getInt("hospital_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String speciality = resultSet.getString("speciality");
                doctorArrayList.add(new Doctor(doctor_id,hospital_id,first_name,last_name,speciality));
            } doctorArrayList.stream().forEach(x->x.toString());
        } return doctorArrayList;
    }

    public void deleteFromDoctor (int id) throws SQLException, PSQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_DOCTOR_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void  truncateTable () throws SQLException, PSQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TRUNCATE_DOCTOR_TABLE);
            preparedStatement.executeQuery();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void updateDoctorById (int doctor_id,Doctor doctor) throws SQLException, PSQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_BY_ID);
            preparedStatement.setString(1,doctor.getFirst_name());
            preparedStatement.setString(2,doctor.getLast_name());
            preparedStatement.setString(3,doctor.getSpeciality());
            preparedStatement.setInt(4, doctor_id);
            preparedStatement.executeUpdate();
        }
     }


}
