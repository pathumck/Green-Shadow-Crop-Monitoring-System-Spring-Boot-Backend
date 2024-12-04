package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.EquipmentDTO;
import lk.ijse.greenshadow.service.EquipmentService;
import lk.ijse.greenshadow.util.AppUtil;
import lk.ijse.greenshadow.util.ResponseUtil;
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

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.updateEquipment(equipmentDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{equipmentId}"})
    public ResponseEntity<Void> deleteEquipment(@PathVariable("equipmentId") String equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllEquipments() {
        return new ResponseUtil("Success", "Retrieved All Equipments", equipmentService.getAllEquipments());
    }

    @GetMapping("/newid")
    public ResponseUtil getNewEquipmentId() {
        return new ResponseUtil("Success", "Retrieved New Equipment Id", AppUtil.generateEquipmentId(equipmentService.findLastEquipmentId()));
    }

    @GetMapping("/{equipmentId}")
    public ResponseUtil getEquipmentById(@PathVariable("equipmentId") String equipmentId) {
        return new ResponseUtil("Success", "Retrieved Equipment", equipmentService.getEquipmentById(equipmentId));
    }
}
