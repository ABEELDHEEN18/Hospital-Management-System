package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Integer> {
    
}
