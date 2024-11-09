package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.CropDTO;

public interface CropService {
    void saveFieldCrops(CropDTO cropDTO);
    void updateFieldCrops(CropDTO cropDTO);
    void deleteCrop(String cropCode);
}
