package lk.ijse.greenshadow.service.impl;

import lk.ijse.greenshadow.dto.CropDTO;
import lk.ijse.greenshadow.exception.CropNotFoundException;
import lk.ijse.greenshadow.exception.DataPersistException;
import lk.ijse.greenshadow.repo.CropRepo;
import lk.ijse.greenshadow.service.CropService;
import lk.ijse.greenshadow.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CropServiceImpl implements CropService {
    @Autowired
    private CropRepo cropRepo;
    @Autowired
    private MapperUtil mapperUtil;
    @Override
    public void saveFieldCrops(CropDTO cropDTO) {
        if (cropRepo.existsById(cropDTO.getCropCode())) {
            throw new DataPersistException(cropDTO.getCropCode() + " : Crop Already Exist");
        }
        cropRepo.save(mapperUtil.mapCropDtoToEntity(cropDTO));
    }

    @Override
    public void updateFieldCrops(CropDTO cropDTO) {
        if (!cropRepo.existsById(cropDTO.getCropCode())) {
            throw new CropNotFoundException(cropDTO.getCropCode() + " : Crop Does Not Exist");
        }
        cropRepo.save(mapperUtil.mapCropDtoToEntity(cropDTO));
    }
}
