package lk.ijse.greenshadow.service.impl;

import lk.ijse.greenshadow.dto.FieldDTO;
import lk.ijse.greenshadow.repo.FieldRepo;
import lk.ijse.greenshadow.service.FieldService;
import lk.ijse.greenshadow.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldRepo fieldRepo;
    @Autowired
    MapperUtil mapperUtil;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        if(fieldRepo.existsById(fieldDTO.getFieldCode())) {
            throw new RuntimeException("Field Already Exist");
        }
        fieldRepo.save(mapperUtil.mapFieldDtoToEntity(fieldDTO));
    }

    @Override
    public void updateField(FieldDTO fieldDTO) {
        if(!fieldRepo.existsById(fieldDTO.getFieldCode())) {
            throw new RuntimeException("Field Does Not Exist");
        }
        fieldRepo.save(mapperUtil.mapFieldDtoToEntity(fieldDTO));
    }

    @Override
    public void deleteField(String fieldCode) {
        if(!fieldRepo.existsById(fieldCode)) {
            throw new RuntimeException("Field Does Not Exist");
        }
        fieldRepo.deleteById(fieldCode);
    }
}
