package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.VehicleDTO;
import lk.ijse.greenshadow.service.VehicleService;
import lk.ijse.greenshadow.util.AppUtil;
import lk.ijse.greenshadow.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{vehicleCode}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String vehicleCode) {
        vehicleService.deleteVehicle(vehicleCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllVehicles() {
        return new ResponseUtil("Success", "Retrieved All Vehicles", vehicleService.getAllVehicles());
    }

    @GetMapping("/newcode")
    public ResponseUtil getNewVehicleCode() {
        return new ResponseUtil("Success", "Retrieved New Vehicle Code", AppUtil.generateVehicleCode(vehicleService.findLastVehicleCode()));
    }
}
