package lk.ijse.greenshadow.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshadow.dto.EquipmentDTO;
import lk.ijse.greenshadow.entity.EquipmentEntity;
import lk.ijse.greenshadow.entity.FieldEntity;
import lk.ijse.greenshadow.entity.StaffEntity;
import lk.ijse.greenshadow.exception.DataPersistException;
import lk.ijse.greenshadow.exception.EquipmentNotFoundException;
import lk.ijse.greenshadow.exception.FieldNotFoundException;
import lk.ijse.greenshadow.exception.StaffNotFoundException;
import lk.ijse.greenshadow.repo.EquipmentRepo;
import lk.ijse.greenshadow.repo.FieldRepo;
import lk.ijse.greenshadow.repo.StaffRepo;
import lk.ijse.greenshadow.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private FieldRepo fieldRepo;
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        if (equipmentRepo.existsById(equipmentDTO.getEquipmentId())) {
            throw new DataPersistException(equipmentDTO.getEquipmentId() + " : Equipment Already Exist");
        }
        Optional<StaffEntity> staff = staffRepo.findById(equipmentDTO.getStaffId());
        Optional<FieldEntity> field = fieldRepo.findById(equipmentDTO.getFieldId());
        if (!staff.isPresent()) {
            throw new StaffNotFoundException(equipmentDTO.getStaffId() + " : Staff Does Not Exist");
        } else if (!field.isPresent()) {
            throw new FieldNotFoundException(equipmentDTO.getFieldId() + " : Field Does Not Exist");
        }
        equipmentRepo.save(new EquipmentEntity(equipmentDTO.getEquipmentId(), equipmentDTO.getName(), equipmentDTO.getType(), equipmentDTO.getStatus(), staff.get(), field.get()));
    }

    @Override
    public void updateEquipment(EquipmentDTO equipmentDTO) {
        if (!equipmentRepo.existsById(equipmentDTO.getEquipmentId())) {
            throw new EquipmentNotFoundException(equipmentDTO.getEquipmentId() + " : Equipment Does Not Exist");
        }
        Optional<StaffEntity> staff = staffRepo.findById(equipmentDTO.getStaffId());
        Optional<FieldEntity> field = fieldRepo.findById(equipmentDTO.getFieldId());
        if (!staff.isPresent()) {
            throw new StaffNotFoundException(equipmentDTO.getStaffId() + " : Staff Does Not Exist");
        } else if (!field.isPresent()) {
            throw new FieldNotFoundException(equipmentDTO.getFieldId() + " : Field Does Not Exist");
        }
        equipmentRepo.save(new EquipmentEntity(equipmentDTO.getEquipmentId(), equipmentDTO.getName(), equipmentDTO.getType(), equipmentDTO.getStatus(), staff.get(), field.get()));
    }

    @Override
    public void deleteEquipment(String equipmentId) {
        if (!equipmentRepo.existsById(equipmentId)) {
            throw new EquipmentNotFoundException(equipmentId + " : Equipment Does Not Exist");
        }
        equipmentRepo.deleteById(equipmentId);
    }
}
