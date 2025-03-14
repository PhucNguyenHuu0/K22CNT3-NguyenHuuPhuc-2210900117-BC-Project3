import React, { useState, useEffect } from 'react';
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { Link } from 'react-router-dom';
import { getRooms } from '../services/roomService';

const RoomList = () => {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    const fetchRooms = async () => {
      const roomsData = await getRooms();
      setRooms(roomsData);
    };

    fetchRooms();
  }, []);

  return (
    <TableContainer component={Paper}>
      <Button component={Link} to="/rooms/add" variant="contained" color="primary" sx={{ mb: 2 }}>
        Add Room
      </Button>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Room Name</TableCell>
            <TableCell>Capacity</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rooms.map(room => (
            <TableRow key={room.id}>
              <TableCell>{room.name}</TableCell>
              <TableCell>{room.capacity}</TableCell>
              <TableCell>
                <Button component={Link} to={`/rooms/edit/${room.id}`} variant="outlined" color="primary" size="small">
                  Edit
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default RoomList;
