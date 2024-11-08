package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO);
    void deleteField(String fieldCode);
    List<FieldDTO> getAllFields();
}
