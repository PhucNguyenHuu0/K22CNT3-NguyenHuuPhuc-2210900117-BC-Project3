import React, { useState, useEffect } from 'react';
import { Button, TextField, Grid, Typography } from '@mui/material';
import { useParams, useHistory } from 'react-router-dom';
import { getUserById, saveUser } from '../services/userService';

const UserForm = () => {
  const [user, setUser] = useState({ name: '', email: '', role: '' });
  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    if (id) {
      const fetchUser = async () => {
        const userData = await getUserById(id);
        setUser(userData);
      };

      fetchUser();
    }
  }, [id]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    await saveUser(user);
    history.push('/users');
  };

  return (
    <form onSubmit={handleSubmit}>
      <Typography variant="h4" gutterBottom>
        {id ? 'Edit User' : 'Add User'}
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <TextField
            label="Name"
            variant="outlined"
            fullWidth
            value={user.name}
            onChange={(e) => setUser({ ...user, name: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Email"
            variant="outlined"
            fullWidth
            value={user.email}
            onChange={(e) => setUser({ ...user, email: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Role"
            variant="outlined"
            fullWidth
            value={user.role}
            onChange={(e) => setUser({ ...user, role: e.target.value })}
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

export default UserForm;
