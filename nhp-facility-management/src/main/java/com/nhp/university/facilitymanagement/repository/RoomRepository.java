package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumberAndBuilding(String roomNumber, String building);
}