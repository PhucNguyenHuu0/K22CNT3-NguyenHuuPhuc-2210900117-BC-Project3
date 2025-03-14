import React, { useState, useEffect } from 'react';
import { Button, TextField, Grid, Typography } from '@mui/material';
import { useParams, useHistory } from 'react-router-dom';
import { getFacilityById, saveFacility } from '../services/facilityService';

const FacilityForm = () => {
  const [facility, setFacility] = useState({ name: '', location: '', type: '' });
  const { id } = useParams();
  const history = useHistory();

  useEffect(() => {
    if (id) {
      const fetchFacility = async () => {
        const facilityData = await getFacilityById(id);
        setFacility(facilityData);
      };

      fetchFacility();
    }
  }, [id]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    await saveFacility(facility);
    history.push('/facilities');
  };

  return (
    <form onSubmit={handleSubmit}>
      <Typography variant="h4" gutterBottom>
        {id ? 'Edit Facility' : 'Add Facility'}
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <TextField
            label="Facility Name"
            variant="outlined"
            fullWidth
            value={facility.name}
            onChange={(e) => setFacility({ ...facility, name: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Location"
            variant="outlined"
            fullWidth
            value={facility.location}
            onChange={(e) => setFacility({ ...facility, location: e.target.value })}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            label="Facility Type"
            variant="outlined"
            fullWidth
            value={facility.type}
            onChange={(e) => setFacility({ ...facility, type: e.target.value })}
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

export default FacilityForm;
