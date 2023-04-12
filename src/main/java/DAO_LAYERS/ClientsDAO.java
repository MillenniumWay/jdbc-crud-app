package DAO_LAYERS;
import Connection.ConnectionManager;
import Models.Client;
import org.postgresql.jdbc2.ArrayAssistant;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO {

    private final String INSERT_INTO_CLIENT= "INSERT INTO client" +
            " (first_name, last_name, passport_num, code_of_diagnose, date_entry, fk_doctor_id) " +
            " VALUES (?,?,?,?,?,?);";
    private final String SELECT_ALL_CLIENTS = "SELECT * FROM client";

    private final String DELETE_FROM_CLIENTS =
            "DELETE FROM client WHERE client_id=?;";

    private final String UPDATE_CLIENT_BY_ID = "UPDATE client " +
            "SET first_name =?,last_name=?,passport_num=?,code_of_diagnose=?,date_entry=?" +
            "WHERE client_id =?;";


    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try  {connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public void insertIntoClients(String first_name, String last_name,
                                  String passport_num, String code_of_diagnose,
                                  String  date_entry, int fk_doctor_id)  throws SQLException{

        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CLIENT);
             preparedStatement.setString(1, first_name);
             preparedStatement.setString(2, last_name);
             preparedStatement.setString(3, passport_num);
             preparedStatement.setString(4, code_of_diagnose);
             preparedStatement.setDate(5, Date.valueOf(date_entry));
             preparedStatement.setInt(6, fk_doctor_id);
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> readAllClients () throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int client_id = resultSet.getInt("client_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String passport_num = resultSet.getString("passport_num");
                String code_of_diagnose = resultSet.getString("code_of_diagnose");
                String date_entry = String.valueOf(resultSet.getDate("date_entry"));
                int fk_doctor_id = resultSet.getInt("fk_doctor_id");
                clients.add(new Client(client_id,first_name, last_name, passport_num,
                        code_of_diagnose, date_entry, fk_doctor_id));
            }
            clients.stream().forEach(x->x.toString());
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public void deleteFromClient (int id) throws SQLException, PSQLException {
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CLIENTS);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
    }

    public void updateCLientById (int client_id, Client client) throws SQLException, PSQLException {
        try (Connection  connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_BY_ID);
            preparedStatement.setString(1, client.getFirst_name());
            preparedStatement.setString(2, client.getLast_name());
            preparedStatement.setString(3,client.getPassport_num());
            preparedStatement.setString(4,client.getCode_of_diagnose());
            preparedStatement.setDate(5,client.getDate_entry());
            preparedStatement.setInt(6, client_id);
            preparedStatement.executeUpdate();
        }
    }

}
