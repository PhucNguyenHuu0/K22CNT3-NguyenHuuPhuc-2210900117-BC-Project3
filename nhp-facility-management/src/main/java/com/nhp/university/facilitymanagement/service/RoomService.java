package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Room;
import com.nhp.university.facilitymanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setName(roomDetails.getName());   // Kiểm tra nếu bị lỗi
        room.setLocation(roomDetails.getLocation());  // Kiểm tra nếu bị lỗi
        return roomRepository.save(room);
    }

}
