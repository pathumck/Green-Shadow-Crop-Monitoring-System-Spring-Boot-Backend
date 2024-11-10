package lk.ijse.greenshadow.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshadow.dto.LogDTO;
import lk.ijse.greenshadow.entity.CropEntity;
import lk.ijse.greenshadow.entity.FieldEntity;
import lk.ijse.greenshadow.entity.LogEntity;
import lk.ijse.greenshadow.entity.StaffEntity;
import lk.ijse.greenshadow.exception.DataPersistException;
import lk.ijse.greenshadow.repo.CropRepo;
import lk.ijse.greenshadow.repo.FieldRepo;
import lk.ijse.greenshadow.repo.LogRepo;
import lk.ijse.greenshadow.repo.StaffRepo;
import lk.ijse.greenshadow.service.LogService;
import lk.ijse.greenshadow.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private FieldRepo fieldRepo;

    @Autowired
    private CropRepo cropRepo;

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private MapperUtil mapperUtil;

    @Transactional
    public void saveLog(LogDTO logDTO) {
        if (logRepo.existsById(logDTO.getLogCode())) {
            throw new DataPersistException(logDTO.getLogCode() + " : Log Already Exist");
        }
        List<FieldEntity> fields = fieldRepo.findAllById(logDTO.getLogFields());
        List<CropEntity> crops = cropRepo.findAllById(logDTO.getLogCrops());
        List<StaffEntity> staffs = staffRepo.findAllById(logDTO.getLogStaff());
        LogEntity logEntity = mapperUtil.mapLogDtoToEntity(logDTO);
        logEntity.setFields(fields);
        logEntity.setCrops(crops);
        logEntity.setStaffs(staffs);
        logRepo.save(logEntity);
    }
}
