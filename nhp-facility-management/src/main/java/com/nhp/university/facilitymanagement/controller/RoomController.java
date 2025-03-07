package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Room;
import com.nhp.university.facilitymanagement.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room, @RequestParam Long locationId) {
        return ResponseEntity.ok(roomService.createRoom(room, locationId));
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId, @Valid @RequestBody Room room) {
        return ResponseEntity.ok(roomService.updateRoom(roomId, room));
    }
}
