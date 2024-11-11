package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.FieldStaffDTO;
import lk.ijse.greenshadow.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    void updateStaff(StaffDTO staffDTO);
    void deleteStaff(String staffId);
    List<StaffDTO> getAllStaffs();
    void saveFieldStaff(FieldStaffDTO fieldStaffDTO);
}