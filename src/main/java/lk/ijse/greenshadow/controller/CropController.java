package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.CropDTO;
import lk.ijse.greenshadow.service.CropService;
import lk.ijse.greenshadow.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/crop")
public class CropController {
    @Autowired
    CropService cropService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestPart("cropCode") String cropCode,
                                   @RequestPart("commonName") String commonName,
                                   @RequestPart("scientificName") String scientificName,
                                   @RequestPart("category") String category,
                                   @RequestPart("season") String season,
                                   @RequestPart("image") MultipartFile image) {
        try {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = AppUtil.imageToBase64(imageBytes);
            cropService.saveFieldCrops(new CropDTO(cropCode, commonName, scientificName, category, season, imageBase64));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCrop(@RequestPart("cropCode") String cropCode,
                                   @RequestPart("commonName") String commonName,
                                   @RequestPart("scientificName") String scientificName,
                                   @RequestPart("category") String category,
                                   @RequestPart("season") String season,
                                   @RequestPart("image") MultipartFile image) {
        try {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = AppUtil.imageToBase64(imageBytes);
            cropService.updateFieldCrops(new CropDTO(cropCode, commonName, scientificName, category, season, imageBase64));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
