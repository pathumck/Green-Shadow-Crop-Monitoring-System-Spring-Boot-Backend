package lk.ijse.greenshadow.util;

import lk.ijse.greenshadow.dto.CropDTO;
import lk.ijse.greenshadow.dto.FieldDTO;
import lk.ijse.greenshadow.entity.CropEntity;
import lk.ijse.greenshadow.entity.FieldEntity;
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
}
