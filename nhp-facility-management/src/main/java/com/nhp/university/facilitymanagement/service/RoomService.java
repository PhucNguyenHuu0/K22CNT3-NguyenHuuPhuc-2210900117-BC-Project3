package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Room;
import java.util.List;

public interface RoomService {
    Room getRoomByRoomNumberAndBuilding(String roomNumber, String building);
    List<Room> getAllRooms();
    Room saveRoom(Room room);
    Room getRoomById(Long id);
    void deleteRoom(Long id);
}