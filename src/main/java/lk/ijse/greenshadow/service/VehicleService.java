package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.VehicleDTO;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleCode);
}
