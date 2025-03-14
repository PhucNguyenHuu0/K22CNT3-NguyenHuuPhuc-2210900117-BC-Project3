package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.model.Room;
import com.nhp.university.facilitymanagement.repository.RoomRepository;
import com.nhp.university.facilitymanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room getRoomByRoomNumberAndBuilding(String roomNumber, String building) {
        return roomRepository.findByRoomNumberAndBuilding(roomNumber, building);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}