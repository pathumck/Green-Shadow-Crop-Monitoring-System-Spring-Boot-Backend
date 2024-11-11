package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.EquipmentDTO;
import lk.ijse.greenshadow.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.saveEquipment(equipmentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}