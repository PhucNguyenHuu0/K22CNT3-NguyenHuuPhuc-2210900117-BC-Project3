import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import MainLayout from './layouts/MainLayout';
import AuthLayout from './layouts/AuthLayout';
import PrivateRoute from './components/PrivateRoute';



// Pages
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import UserManagement from './pages/UserManagement';
import RoomManagement from './pages/RoomManagement';
import FacilityManagement from './pages/FacilityManagement';
import MaintenanceRequests from './pages/MaintenanceRequests';
import NotFound from './pages/NotFound';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        
        {/* Public routes */}
        <Route path="/login" element={
          <AuthLayout>
            <Login />
          </AuthLayout>
        } />

        {/* Protected routes */}
        <Route path="/dashboard" element={
          <PrivateRoute>
            <MainLayout>
              <Dashboard />
            </MainLayout>
          </PrivateRoute>
        } />
        <Route path="/users" element={
          <PrivateRoute>
            <MainLayout>
              <UserManagement />
            </MainLayout>
          </PrivateRoute>
        } />
        <Route path="/rooms" element={
          <PrivateRoute>
            <MainLayout>
              <RoomManagement />
            </MainLayout>
          </PrivateRoute>
        } />
        <Route path="/facilities" element={
          <PrivateRoute>
            <MainLayout>
              <FacilityManagement />
            </MainLayout>
          </PrivateRoute>
        } />
        <Route path="/maintenance" element={
          <PrivateRoute>
            <MainLayout>
              <MaintenanceRequests />
            </MainLayout>
          </PrivateRoute>
        } />

        {/* 404 page */}
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;