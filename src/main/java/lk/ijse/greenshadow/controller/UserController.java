package lk.ijse.greenshadow.controller;

import lk.ijse.greenshadow.repo.UserRepo;
import lk.ijse.greenshadow.service.UserService;
import lk.ijse.greenshadow.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseUtil getAllUsers() {
        return new ResponseUtil("Success", "Retrieved All Users", userService.getAllUsers());
    }
}
