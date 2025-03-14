import React, { useState, useEffect } from 'react';
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { Link } from 'react-router-dom';
import { getFacilities } from '../services/facilityService';

const FacilityList = () => {
  const [facilities, setFacilities] = useState([]);

  useEffect(() => {
    const fetchFacilities = async () => {
      const facilityData = await getFacilities();
      setFacilities(facilityData);
    };

    fetchFacilities();
  }, []);

  return (
    <TableContainer component={Paper}>
      <Button component={Link} to="/facilities/add" variant="contained" color="primary" sx={{ mb: 2 }}>
        Add Facility
      </Button>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
            <TableCell>Location</TableCell>
            <TableCell>Type</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {facilities.map(facility => (
            <TableRow key={facility.id}>
              <TableCell>{facility.name}</TableCell>
              <TableCell>{facility.location}</TableCell>
              <TableCell>{facility.type}</TableCell>
              <TableCell>
                <Button component={Link} to={`/facilities/edit/${facility.id}`} variant="outlined" color="primary" size="small">
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

export default FacilityList;
