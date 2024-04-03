package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicine {
    @Id
    private int medicineId;
    private String medicineName;
    private int medicinePrice;
    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    public int getMedicinePrice() {
        return medicinePrice;
    }
    public void setMedicinePrice(int medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
    public Medicine(int medicineId, String medicineName, int medicinePrice) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
    }
    public Medicine() {
    }
    
}
