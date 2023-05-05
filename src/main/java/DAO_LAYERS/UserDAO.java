package DAO_LAYERS;
import Models.UserBean;
import Connection.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {

    private final String INSERT_INTO_USERS = "INSERT INTO users " + "(login, email, password) VALUES" +
            "(?,?,?);";
    private final String UPDATE_USER = "UPDATE users SET login =?, email=?, password=? WHERE id=?;";
    private final String SELECT_USER_BY_ID = "SELECT id, login, email, password FROM users WHERE id = ?;";
    private final String SELECT_ALL_USERS = "SELECT * FROM users";
    private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?;";

    private final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =

            "SELECT * FROM author WHERE au.email = ? AND au.password = ?";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
         try  {
            connection = ConnectionManager.open();
        } catch (Exception e) {
            throw e;
        }
        return connection;
    }

    public UserBean yakkkuithemaid(String email) {
         UserBean userBean = null;
        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String email_ = resultSet.getString("email");
                String password_ = resultSet.getString("password");
                userBean = new UserBean(id,login,password_,email_);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userBean;
    }

    @SneakyThrows
    public Optional<UserBean> findByEmailAndPassword(String email, String password) {
        try (Connection connection = getConnection();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();
            UserBean user = null;
            if(resultSet.next()) {
                String login = resultSet.getString("login");
                String email1 = resultSet.getString("email");
                String password1 = resultSet.getString("password");
                user = new UserBean(login,email1,password1);

                String info = user.getEmail();

                System.out.println("UserInfo: " + info);
            }

            return Optional.ofNullable(user);
        }
    }
    // Create New User / Create
    public void insertUsers(UserBean userBean) throws SQLException{

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USERS)) {
            preparedStatement.setString(1, userBean.getLogin());
            preparedStatement.setString(2, userBean.getEmail());
            preparedStatement.setString(3, userBean.getPassword());
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    // Update User / Create
    public boolean updateUsers(UserBean userBean) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
             preparedStatement.setInt(1, userBean.getId());
             preparedStatement.setString(2, userBean.getLogin());
             preparedStatement.setString(3, userBean.getEmail());
             preparedStatement.setString(4, userBean.getPassword());
             rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    // Find User / Read

    public UserBean findUserById (int id) throws SQLException {
        UserBean userBean = null;
        try(Connection connection = getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                userBean = new UserBean( id,login, password, email);
            }
        } catch (Exception e) { e.printStackTrace();
        }
        return userBean;
    }

    public List<UserBean> selectAllUsers() throws SQLException {
        ArrayList<UserBean> userBean = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                userBean.add(new UserBean(id, login, password, email));
            }
        } catch (Exception e) { e.printStackTrace();
        }
        return userBean;
    }

    // Delete User By ID / Delete
    public boolean deleteUser (int id) throws SQLException {
        boolean delete;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);) {
             preparedStatement.setInt(1, id);
             delete = preparedStatement.executeUpdate() > 0;
        }
     return delete;
    }


}
