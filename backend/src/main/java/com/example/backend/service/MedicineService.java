package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Medicine;
import com.example.backend.repository.MedicineRepo;

@Service
public class MedicineService {
    
    @Autowired
    MedicineRepo sr;

    public Medicine create(Medicine se)
    {
        if (se != null) {
            return sr.save(se);
        } else {
            // Handle null case (e.g., throw an exception, return a default value)
            throw new IllegalArgumentException("Signup object cannot be null");
        }
    }

    public List<Medicine> getAllUser()
    {
        return sr.findAll();
    }

    public Medicine getUserbyId(int userId)
    {
        return sr.findById(userId).orElse(null);
    }

    public boolean updateUser(int userId, Medicine se)
    {
        if(this.getUserbyId(userId)==null)
            return false;

        if(se!=null)
            sr.save(se);
        else    
            throw new IllegalArgumentException("No user with given user Id found");

        return true;   
    }

    public boolean deleteUser(int userId)
    {
        if(this.getUserbyId(userId)==null)
            return false;
        
        sr.deleteById(userId);

        return true;
    }
}