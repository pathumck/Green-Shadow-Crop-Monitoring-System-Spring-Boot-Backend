package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.dto.FieldDTO;
import lk.ijse.greenshadow.service.FieldService;
import lk.ijse.greenshadow.util.AppUtil;
import lk.ijse.greenshadow.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/field")
public class FieldController {
    @Autowired
    FieldService fieldService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil saveField(@RequestPart("fieldCode") String fieldCode,
                                  @RequestPart("name") String name,
                                  @RequestPart("location") String location,
                                  @RequestPart("size") String size,
                                  @RequestPart("imageOne") MultipartFile imageOne,
                                  @RequestPart("imageTwo") MultipartFile imageTwo) {
        try {
            byte[] imageOneBytes = imageOne.getBytes();
            byte[] imageTwoBytes = imageTwo.getBytes();
            String imageOneBase64 = AppUtil.imageToBase64(imageOneBytes);
            String imageTwoBase64 = AppUtil.imageToBase64(imageTwoBytes);

            fieldService.saveField(new FieldDTO(fieldCode, name, location, size, imageOneBase64, imageTwoBase64));
            return new ResponseUtil("Success", "Field Saved", null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil updateField(@RequestPart("fieldCode") String fieldCode,
                                  @RequestPart("name") String name,
                                  @RequestPart("location") String location,
                                  @RequestPart("size") String size,
                                  @RequestPart("imageOne") MultipartFile imageOne,
                                  @RequestPart("imageTwo") MultipartFile imageTwo) {
        try {
            byte[] imageOneBytes = imageOne.getBytes();
            byte[] imageTwoBytes = imageTwo.getBytes();
            String imageOneBase64 = AppUtil.imageToBase64(imageOneBytes);
            String imageTwoBase64 = AppUtil.imageToBase64(imageTwoBytes);

            fieldService.updateField(new FieldDTO(fieldCode, name, location, size, imageOneBase64, imageTwoBase64));
            return new ResponseUtil("Success", "Field Updated", null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
