package com.nhp.university.facilitymanagement.model;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facilities")
@Getter
@Setter
@NoArgsConstructor
@EnableJpaRepositories(basePackages = "com.nhp.university.facilitymanagement.repository")

@AllArgsConstructor
public class Facility {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
