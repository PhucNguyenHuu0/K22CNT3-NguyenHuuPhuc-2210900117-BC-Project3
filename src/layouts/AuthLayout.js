import React from 'react';
import { 
  Container, 
  Box, 
  Paper, 
  Typography, 
  CssBaseline 
} from '@mui/material';
import SchoolIcon from '@mui/icons-material/School';

const AuthLayout = ({ children }) => {
  return (
    <Box
      sx={{
        minHeight: '100vh',
        display: 'flex',
        backgroundColor: '#f0f2f5',
        backgroundImage: 'linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%)',
        pt: 8,
        pb: 6,
      }}
    >
      <CssBaseline />
      <Container maxWidth="sm">
        <Paper 
          elevation={6} 
          sx={{ 
            p: 4, 
            display: 'flex', 
            flexDirection: 'column', 
            alignItems: 'center',
            borderRadius: 2
          }}
        >
          <Box 
            sx={{ 
              display: 'flex', 
              alignItems: 'center', 
              flexDirection: 'column', 
              mb: 4 
            }}
          >
            <Box 
              sx={{ 
                backgroundColor: '#1976d2', 
                borderRadius: '50%', 
                p: 2, 
                mb: 2, 
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center'
              }}
            >
              <SchoolIcon sx={{ fontSize: 40, color: 'white' }} />
            </Box>
            <Typography 
              component="h1" 
              variant="h4" 
              color="primary" 
              fontWeight="bold"
            >
              University Facility
            </Typography>
            <Typography 
              variant="h6" 
              color="text.secondary"
            >
              Management System
            </Typography>
          </Box>
          {children}
        </Paper>
        <Box sx={{ mt: 3, textAlign: 'center' }}>
          <Typography variant="body2" color="text.secondary">
            © {new Date().getFullYear()} University Facility Management. All rights reserved.
          </Typography>
        </Box>
      </Container>
    </Box>
  );
};

export default AuthLayout;