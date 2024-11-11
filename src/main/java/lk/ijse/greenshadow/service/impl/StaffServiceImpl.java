package lk.ijse.greenshadow.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.greenshadow.dto.StaffDTO;
import lk.ijse.greenshadow.exception.DataPersistException;
import lk.ijse.greenshadow.exception.StaffNotFoundException;
import lk.ijse.greenshadow.repo.StaffRepo;
import lk.ijse.greenshadow.service.StaffService;
import lk.ijse.greenshadow.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private MapperUtil mapperUtil;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        if (staffRepo.existsById(staffDTO.getStaffId())) {
            throw new DataPersistException(staffDTO.getStaffId() + " : Staff Already Exist");
        }
        staffRepo.save(mapperUtil.mapStaffDtoToEntity(staffDTO));
    }

    @Override
    public void updateStaff(StaffDTO staffDTO) {
        if (!staffRepo.existsById(staffDTO.getStaffId())) {
           throw new StaffNotFoundException(staffDTO.getStaffId() + " : Staff Does Not Exist");
        }
        staffRepo.save(mapperUtil.mapStaffDtoToEntity(staffDTO));
    }

    @Override
    public void deleteStaff(String staffId) {
        if (!staffRepo.existsById(staffId)) {
            throw new StaffNotFoundException(staffId + " : Staff Does Not Exist");
        }
        staffRepo.deleteById(staffId);
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return mapperUtil.mapStaffEntitiesToDtos(staffRepo.findAll());
    }
}
