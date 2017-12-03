package main.service;

import main.dao.VehicleDAO;
import main.model.Vehicle;

import java.util.List;

public class VehicleService {

        private VehicleDAO vehicleDAO;

        public VehicleService() {
            this.vehicleDAO = new VehicleDAO();
        }

        public List<Vehicle> getAllVehicles () {
            return this.vehicleDAO.getAllVehicles();
        }

        public boolean insertVehicle (Vehicle vehicle) {
            return this.vehicleDAO.insertVehicle(vehicle);
        }
    }