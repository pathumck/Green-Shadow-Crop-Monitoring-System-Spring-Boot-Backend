package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.LogDTO;
import lk.ijse.greenshadow.exception.DataPersistException;
import lk.ijse.greenshadow.service.LogService;
import lk.ijse.greenshadow.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogService logService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveLog(@RequestParam("logCode") String logCode,
                                        @RequestParam("date") String date,
                                        @RequestParam("details") String details,
                                        @RequestParam("image") MultipartFile image,
                                        @RequestParam("logFields")List<String> logFields,
                                        @RequestParam("logCrops")List<String> logCrops,
                                        @RequestParam("logStaff")List<String> logStaff) {
        try {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = AppUtil.imageToBase64(imageBytes);
            logService.saveLog(new LogDTO(logCode, date, details, imageBase64, logFields, logCrops, logStaff));
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistException e) {
            throw new DataPersistException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
