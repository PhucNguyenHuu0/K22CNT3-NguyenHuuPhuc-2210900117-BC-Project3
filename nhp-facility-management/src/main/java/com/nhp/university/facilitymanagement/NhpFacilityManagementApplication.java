package com.nhp.university.facilitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nhp.university.facilitymanagement")
public class NhpFacilityManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(NhpFacilityManagementApplication.class, args);
    }
}