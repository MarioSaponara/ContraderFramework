package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
        private final String QUERY_ALL = "select * from vehicle";
        private final String QUERY_INSERT = "insert into vehicle (idVehicle, brand, model, fuel, version, capacity) values (NULL,?,?,?,?,?)";

        public VehicleDAO() {

        }

        public List<Vehicle> getAllVehicles () {
            List<Vehicle> vehicles = new ArrayList<>();
            Connection connection = ConnectionSingleton.getInstance();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QUERY_ALL);
                while (resultSet.next()) {
                    Integer idVehicle=resultSet.getInt("idVehicle");
                    String brand = resultSet.getString("brand");
                    String model = resultSet.getString("model");
                    String fuel = resultSet.getString("fuel");
                    String version = resultSet.getString("version");
                    String capacity = resultSet.getString("capacity");
                    vehicles.add(new Vehicle(idVehicle, brand, model, fuel, version, capacity));
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return vehicles;
        }

        public boolean insertVehicle(Vehicle vehicle) {
            Connection connection = ConnectionSingleton.getInstance();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
                preparedStatement.setString(1, vehicle.getBrand());
                preparedStatement.setString(2, vehicle.getModel());
                preparedStatement.setString(3, vehicle.getFuel());
                preparedStatement.setString(4, vehicle.getVersion());
                preparedStatement.setString(5, vehicle.getCapacity());
                return preparedStatement.execute();
            }
            catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }
        }
    }