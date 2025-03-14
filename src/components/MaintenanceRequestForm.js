import React, { useState, useEffect } from 'react';
import { Button, TextField, Grid, Typography } from '@mui/material';
import { useParams, useHistory } from 'react-router-dom';
import { getMaintenanceRequestById, saveMaintenanceRequest } from '../services/maintenanceRequestService';

const MaintenanceRequestForm = () => {
  const [maintenanceRequest, setMaintenanceRequest] = useState({ description: '', status: '' });
  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    if (id) {
      const fetchRequest = async () => {
        const requestData = await getMaintenanceRequestById(id);
        setMaintenanceRequest(requestData);
      };

      fetchRequest();
    }
  }, [id]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    await saveMaintenanceRequest(maintenanceRequest);
    history.push('/maintenance');
  };

  return (
    <form onSubmit={handleSubmit}>
      <Typography variant="h4" gutterBottom>
        {id ? 'Edit Maintenance Request' : 'Add Maintenance Request'}
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <TextField
            label="Description"
            variant="outlined"
            fullWidth
            value={maintenanceRequest.description}
            onChange={(e) => setMaintenanceRequest({ ...maintenanceRequest, description: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Status"
            variant="outlined"
            fullWidth
            value={maintenanceRequest.status}
            onChange={(e) => setMaintenanceRequest({ ...maintenanceRequest, status: e.target.value })}
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

export default MaintenanceRequestForm;
