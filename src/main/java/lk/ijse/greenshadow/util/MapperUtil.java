package lk.ijse.greenshadow.util;

import lk.ijse.greenshadow.dto.*;
import lk.ijse.greenshadow.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperUtil {
    @Autowired
    private ModelMapper modelMapper;
    public FieldEntity mapFieldDtoToEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
    public List<FieldDTO> mapFieldEntitiesToDtos(List<FieldEntity> fieldEntities) {
        return modelMapper.map(fieldEntities, new TypeToken<List<FieldDTO>>() {}.getType());
    }

    public CropEntity mapCropDtoToEntity(CropDTO cropDTO) {
        return modelMapper.map(cropDTO, CropEntity.class);
    }

    public List<CropDTO> mapCropEntitiesToDtos(List<CropEntity> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDTO>>() {}.getType());
    }

    public LogEntity mapLogDtoToEntity(LogDTO logDTO) {
        return modelMapper.map(logDTO, LogEntity.class);
    }

    public List<LogDTO> mapLogEntitiesToDtos(List<LogEntity> logEntities) {
        return modelMapper.map(logEntities, new TypeToken<List<LogDTO>>() {}.getType());
    }

    public StaffEntity mapStaffDtoToEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, StaffEntity.class);
    }

    public List<StaffDTO> mapStaffEntitiesToDtos(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>() {}.getType());
    }

    public VehicleEntity mapVehicleDtoToEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }

    public EquipmentEntity mapEquipmentDtoToEntity(EquipmentDTO equipmentDTO) {
        return modelMapper.map(equipmentDTO, EquipmentEntity.class);
    }
}
