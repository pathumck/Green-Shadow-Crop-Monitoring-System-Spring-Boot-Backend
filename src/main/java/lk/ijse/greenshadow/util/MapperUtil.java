package lk.ijse.greenshadow.util;

import lk.ijse.greenshadow.dto.FieldDTO;
import lk.ijse.greenshadow.entity.FieldEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {
    @Autowired
    private ModelMapper modelMapper;
    public FieldEntity mapFieldDtoToEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
}