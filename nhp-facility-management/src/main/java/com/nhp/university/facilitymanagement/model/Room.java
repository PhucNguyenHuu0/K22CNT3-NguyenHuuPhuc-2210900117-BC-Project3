package com.nhp.university.facilitymanagement.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity Room đại diện cho phòng trong cơ sở vật chất.
 */
@Entity
@Table(name = "nhp_rooms")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nhpId;
    
    private String nhpName;
    
    private Integer nhpCapacity;

    // Getters và Setters
    public Long getNhpId() {
        return nhpId;
    }
    public void setNhpId(Long nhpId) {
        this.nhpId = nhpId;
    }
    public String getNhpName() {
        return nhpName;
    }
    public void setNhpName(String nhpName) {
        this.nhpName = nhpName;
    }
    public Integer getNhpCapacity() {
        return nhpCapacity;
    }
    public void setNhpCapacity(Integer nhpCapacity) {
        this.nhpCapacity = nhpCapacity;
    }
}
