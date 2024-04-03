package com.example.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Medicine;
import com.example.backend.service.MedicineService;

@RestController
public class MedicineController {

    @Autowired
    MedicineService ss;

    @PostMapping("/api/medicine")
    public ResponseEntity<Medicine> postUser(@RequestBody Medicine medicine)
    {
        Medicine obj = ss.create(medicine);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("/api/medicine")
    public ResponseEntity<List<Medicine>> getAllUserController()
    {
        List<Medicine> obj = ss.getAllUser();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @GetMapping("/api/medicine/{userId}")
    public ResponseEntity<Medicine> getUserByIdController(@PathVariable int userId)
    {
        Medicine obj = ss.getUserbyId(userId);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/medicine/{userId}")
    public ResponseEntity<Medicine> updateUserController(@PathVariable int userId,@RequestBody Medicine se)
    {
        if(ss.updateUser(userId, se)==true)
            return new ResponseEntity<>(se, HttpStatus.OK);
        else
            return new ResponseEntity<>(se,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/api/medicine/{userId}")
    public ResponseEntity<Boolean> deleteUserController(@PathVariable int userId)
    {
        if(ss.deleteUser(userId)==true)
            return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}