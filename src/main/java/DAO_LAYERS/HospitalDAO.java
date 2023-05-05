package DAO_LAYERS;
import Connection.ConnectionManager;
import Models.Hospital;
import Models.UserBean;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
    private static final HospitalDAO INSTANCE = new HospitalDAO();


    private final String INSERT_INTO_HOSPITAL = "INSERT INTO hospital " + "(name_hospital, specialisation) VALUES" +
            "(?,?);";
    private final String SELECT_ALL_HOSPITALS = "SELECT * FROM hospital";
    private final String UPDATE_HOSPITAL = "UPDATE hospital SET name_hospital =?, specialisation=? WHERE id_hospital=?;";
    private final String SELECT_HOSPITAL_BY_ID = "SELECT name_hospital, specialisation FROM hospital WHERE id_hospital = ?;";
    private final String DELETE_HOSPITAL_BY_ID = "" +
            "DELETE FROM client WHERE fk_doctor_id=?;" +
            "DELETE FROM doctor WHERE hospital_id=?;" +
            "DELETE FROM hospital WHERE id_hospital=?;";

    private final String TRUNCATE_FROM_HOSPITAL = "TRUNCATE TABLE hospital CASCADE";


    private String specialisation;
    private String name_hospital;

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {
            connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }
    public void insertIntoHospital (String name_hospital, String specialisation ) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_HOSPITAL);
            preparedStatement.setString(1,name_hospital);
            preparedStatement.setString(2,specialisation);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Hospital selectById (int id) throws SQLException {
        Hospital hospital = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOSPITAL_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name_hospital = resultSet.getString("name_hospital");
                String specialisation = resultSet.getString("specialisation");
                hospital = new Hospital(name_hospital, specialisation);
            }
            } catch (Exception e) { e.printStackTrace();
        }
        return hospital;
        }
        public List<Hospital> selectAllHospitals () throws SQLException {
            ArrayList<Hospital> hospitals = new ArrayList<>();
            try(Connection connection = getConnection()){
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOSPITALS);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id_hospital = resultSet.getInt("id_hospital");
                    String name_hospital = resultSet.getString("name_hospital");
                    String specialisation = resultSet.getString("specialisation");
                    hospitals.add(new Hospital(id_hospital,name_hospital,specialisation));
                } hospitals.stream().forEach(x-> System.out.println(x));
            }
            return hospitals;
        }
    public boolean updateHospital(int id_hospital, Hospital hospital) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOSPITAL);) {
             preparedStatement.setString(1, hospital.getName_hospital());
             preparedStatement.setString(2, hospital.getSpecialisation());
             preparedStatement.setInt(3, id_hospital);

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
   public boolean deleteHospital (int id, int id_of_doctor) throws  SQLException{
        boolean delete;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOSPITAL_BY_ID)){
            preparedStatement.setInt(1,3);
            preparedStatement.setInt(2,id);
            preparedStatement.setInt(3,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            delete = preparedStatement.executeUpdate() > 0;
        }
    return delete;
   }


   public void turncateFromHospital () throws SQLException, PSQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TRUNCATE_FROM_HOSPITAL);
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    public static HospitalDAO getInstance() {
        return INSTANCE;
    }

}





