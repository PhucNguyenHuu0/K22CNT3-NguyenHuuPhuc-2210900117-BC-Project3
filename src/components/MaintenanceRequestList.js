import React, { useState, useEffect } from 'react';
import { Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { Link } from 'react-router-dom';
import { getMaintenanceRequests } from '../services/maintenanceRequestService';

const MaintenanceRequestList = () => {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    const fetchRequests = async () => {
      const requestData = await getMaintenanceRequests();
      setRequests(requestData);
    };

    fetchRequests();
  }, []);

  return (
    <TableContainer component={Paper}>
      <Button component={Link} to="/maintenance/add" variant="contained" color="primary" sx={{ mb: 2 }}>
        Add Maintenance Request
      </Button>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Description</TableCell>
            <TableCell>Status</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {requests.map(request => (
            <TableRow key={request.id}>
              <TableCell>{request.description}</TableCell>
              <TableCell>{request.status}</TableCell>
              <TableCell>
                <Button component={Link} to={`/maintenance/edit/${request.id}`} variant="outlined" color="primary" size="small">
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

export default MaintenanceRequestList;
