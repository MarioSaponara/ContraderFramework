package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String QUERY_ALL = "select * from users";
    private final String QUERY_INSERT = "insert into users (idusers, username, password, firstname, lastname, dateofBirth, cf, businessname, vat, municipality, postecode, city, address, telephone, role) values (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public UserDAO() {

    }

    public boolean insertUser(User user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getDateofBirth());
            preparedStatement.setString(6, user.getCf());
            preparedStatement.setString(7, user.getBusinessname());
            preparedStatement.setString(8, user.getVat());
            preparedStatement.setString(9, user.getMunicipality());
            preparedStatement.setString(10, user.getPostecode());
            preparedStatement.setString(11, user.getCity());
            preparedStatement.setString(12, user.getAddress());
            preparedStatement.setString(13, user.getTelephone());
            preparedStatement.setString(14, "user");
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public List<User> getAllUsers () {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                Integer idUser=resultSet.getInt("idUsers");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String dateofBirth = resultSet.getString("dateofBirth");
                String cf = resultSet.getString("cf");
                String businessname = resultSet.getString("businessname");
                String vat = resultSet.getString("vat");
                String municipality = resultSet.getString("municipality");
                String postecode = resultSet.getString("postecode");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String role = resultSet.getString("role");
                users.add(new User(idUser, username, password, firstname, lastname, dateofBirth, cf, businessname, vat, municipality, postecode, city, address, telephone, role));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
