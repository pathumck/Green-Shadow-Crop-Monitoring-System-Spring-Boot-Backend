package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.FieldStaffDTO;
import lk.ijse.greenshadow.dto.StaffDTO;
import lk.ijse.greenshadow.service.StaffService;
import lk.ijse.greenshadow.util.AppUtil;
import lk.ijse.greenshadow.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDTO staffDTO) {
        staffService.saveStaff(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@RequestBody StaffDTO staffDTO) {
        staffService.updateStaff(staffDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{staffId}")
    public ResponseEntity<Void> deleteStaff(@PathVariable String staffId) {
        staffService.deleteStaff(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseUtil getAllStaffs() {
        return new ResponseUtil("Success", "Retrieved All Staffs", staffService.getAllStaffs());
    }

    @PostMapping(value = "/fieldstaff", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveFieldStaff(@RequestBody FieldStaffDTO fieldStaffDTO) {
        staffService.saveFieldStaff(fieldStaffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/fieldstaff")
    public ResponseEntity<Void> deleteFieldStaff(@RequestParam("fieldCode") String fieldCode, @RequestParam("staffId") String staffId) {
        staffService.deleteFieldStaff(fieldCode, staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/newstaffid")
    public ResponseUtil getNewStaffId() {
        return new ResponseUtil("Success", "Retrieved New Staff Id", AppUtil.generateStaffId(staffService.findLastStaffId()));
    }
}
