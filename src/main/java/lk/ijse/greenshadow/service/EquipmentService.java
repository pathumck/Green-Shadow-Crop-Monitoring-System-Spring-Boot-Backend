package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.EquipmentDTO;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    void updateEquipment(EquipmentDTO equipmentDTO);
    void deleteEquipment(String equipmentId);
}
