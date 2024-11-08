package lk.ijse.greenshadow.service;

import lk.ijse.greenshadow.dto.FieldDTO;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO);
    void deleteField(String fieldCode);
}
