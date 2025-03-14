import React, { useState, useEffect } from 'react';
import { Button, TextField, Grid, Typography } from '@mui/material';
import { useParams, useHistory } from 'react-router-dom';
import { getRoomById, saveRoom } from '../services/roomService';

const RoomForm = () => {
  const [room, setRoom] = useState({ name: '', capacity: '' });
  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    if (id) {
      const fetchRoom = async () => {
        const roomData = await getRoomById(id);
        setRoom(roomData);
      };

      fetchRoom();
    }
  }, [id]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    await saveRoom(room);
    history.push('/rooms');
  };

  return (
    <form onSubmit={handleSubmit}>
      <Typography variant="h4" gutterBottom>
        {id ? 'Edit Room' : 'Add Room'}
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <TextField
            label="Room Name"
            variant="outlined"
            fullWidth
            value={room.name}
            onChange={(e) => setRoom({ ...room, name: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Capacity"
            variant="outlined"
            fullWidth
            value={room.capacity}
            onChange={(e) => setRoom({ ...room, capacity: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <Button type="submit" variant="contained" color="primary">
            Save
          </Button>
        </Grid>
      </Grid>
    </form>
  );
};

export default RoomForm;
