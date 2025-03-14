import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  Box,
  Grid,
  Paper,
  Typography,
  Card,
  CardContent,
  Divider,
  List,
  ListItem,
  ListItemText,
  ListItemAvatar,
  Avatar,
  IconButton,
  LinearProgress,
  Chip,
  CircularProgress,
} from '@mui/material';
import PeopleIcon from '@mui/icons-material/People';
import MeetingRoomIcon from '@mui/icons-material/MeetingRoom';
import BusinessIcon from '@mui/icons-material/Business';
import BuildIcon from '@mui/icons-material/Build';
import TrendingUpIcon from '@mui/icons-material/TrendingUp';
import TrendingDownIcon from '@mui/icons-material/TrendingDown';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import PersonIcon from '@mui/icons-material/Person';
import {
  getUsers,
  getRooms,
  getFacilities,
  getMaintenanceRequests,
} from '../services'; // Giả định các service này tồn tại

// Thành phần StatCard
const StatCard = ({ title, value, icon, color, trend, trendValue }) => (
  <Card sx={{ height: '100%' }}>
    <CardContent>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 3 }}>
        <Box>
          <Typography variant="h6" color="text.secondary" gutterBottom>
            {title}
          </Typography>
          <Typography variant="h4" fontWeight="bold">
            {value}
          </Typography>
        </Box>
        <Avatar sx={{ bgcolor: `${color}.light`, color: `${color}.main` }}>
          {icon}
        </Avatar>
      </Box>
      <Box sx={{ display: 'flex', alignItems: 'center' }}>
        {trend === 'up' ? (
          <TrendingUpIcon sx={{ color: 'success.main', mr: 1, fontSize: 18 }} />
        ) : (
          <TrendingDownIcon sx={{ color: 'error.main', mr: 1, fontSize: 18 }} />
        )}
        <Typography
          variant="body2"
          color={trend === 'up' ? 'success.main' : 'error.main'}
          fontWeight="bold"
        >
          {trendValue}
        </Typography>
        <Typography variant="body2" color="text.secondary" sx={{ ml: 1 }}>
          from last month
        </Typography>
      </Box>
    </CardContent>
  </Card>
);

// Thành phần biểu đồ đơn giản
const SimpleChart = ({ data, color }) => {
  if (!data || data.length === 0) {
    return <Typography variant="body2">No data available</Typography>;
  }
  return (
    <Box sx={{ height: 60, width: '100%', display: 'flex', alignItems: 'flex-end' }}>
      {data.map((value, index) => (
        <Box
          key={index}
          sx={{
            height: `${value}%`,
            width: '10%',
            backgroundColor: color,
            mx: 0.5,
            borderTopLeftRadius: 4,
            borderTopRightRadius: 4,
            opacity: 0.7 + index * 0.05,
          }}
        />
      ))}
    </Box>
  );
};

const Dashboard = () => {
  const navigate = useNavigate();
  const [stats, setStats] = useState({
    users: 0,
    rooms: 0,
    facilities: 0,
    maintenance: 0,
  });
  const [maintenanceRequests, setMaintenanceRequests] = useState([]);
  const [roomUtilization, setRoomUtilization] = useState([]);
  const [chartData, setChartData] = useState({ lectureHalls: [], labs: [] });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Lấy dữ liệu từ API
  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const [usersData, roomsData, facilitiesData, maintenanceData] = await Promise.all([
          getUsers(),
          getRooms(),
          getFacilities(),
          getMaintenanceRequests(),
        ]);

        setStats({
          users: usersData.length,
          rooms: roomsData.length,
          facilities: facilitiesData.length,
          maintenance: maintenanceData.length,
        });

        setMaintenanceRequests(maintenanceData.slice(0, 3)); // Lấy 3 yêu cầu gần đây
        setRoomUtilization(
          roomsData.map((room) => ({
            room: room.name,
            utilization: room.utilization || Math.floor(Math.random() * 100), // Giả lập nếu không có
          }))
        );
        setChartData({
          lectureHalls: [30, 40, 45, 50, 55, 70, 65, 60, 65, 90], // Giả lập
          labs: [50, 45, 40, 30, 40, 50, 40, 30, 45, 50], // Giả lập
        });
      } catch (err) {
        setError('Failed to load dashboard data');
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  if (loading) {
    return (
      <Box sx={{ display: 'flex', justifyContent: 'center', mt: 5 }}>
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return (
      <Typography variant="h6" color="error" align="center" sx={{ mt: 5 }}>
        {error}
      </Typography>
    );
  }

  return (
    <Box sx={{ p: 3 }}>
      <Box sx={{ mb: 4, display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <Typography variant="h4" fontWeight="medium">
          Dashboard
        </Typography>
        <Chip label="Academic Year 2024-2025" color="primary" variant="outlined" />
      </Box>

      <Grid container spacing={3}>
        {/* Thẻ thống kê */}
        <Grid item xs={12} sm={6} md={3}>
          <StatCard
            title="Total Users"
            value={stats.users}
            icon={<PeopleIcon />}
            color="primary"
            trend="up"
            trendValue="12%"
          />
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <StatCard
            title="Rooms"
            value={stats.rooms}
            icon={<MeetingRoomIcon />}
            color="info"
            trend="up"
            trendValue="5%"
          />
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <StatCard
            title="Facilities"
            value={stats.facilities}
            icon={<BusinessIcon />}
            color="success"
            trend="up"
            trendValue="8%"
          />
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <StatCard
            title="Maintenance"
            value={stats.maintenance}
            icon={<BuildIcon />}
            color="warning"
            trend="down"
            trendValue="3%"
          />
        </Grid>

        {/* Biểu đồ */}
        <Grid item xs={12} md={8}>
          <Paper sx={{ p: 3, height: '100%' }}>
            <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 2 }}>
              <Typography variant="h6">Room Booking Trends</Typography>
              <IconButton size="small">
                <MoreVertIcon />
              </IconButton>
            </Box>
            <Divider sx={{ mb: 3 }} />
            <Grid container spacing={3}>
              <Grid item xs={12} sm={6}>
                <Typography variant="subtitle2" color="text.secondary" gutterBottom>
                  Lecture Halls
                </Typography>
                <SimpleChart data={chartData.lectureHalls} color="#1976d2" />
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mt: 1 }}>
                  <Typography variant="caption" color="text.secondary">Jan</Typography>
                  <Typography variant="caption" color="text.secondary">Oct</Typography>
                </Box>
              </Grid>
              <Grid item xs={12} sm={6}>
                <Typography variant="subtitle2" color="text.secondary" gutterBottom>
                  Labs & Meeting Rooms
                </Typography>
                <SimpleChart data={chartData.labs} color="#2e7d32" />
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mt: 1 }}>
                  <Typography variant="caption" color="text.secondary">Jan</Typography>
                  <Typography variant="caption" color="text.secondary">Oct</Typography>
                </Box>
              </Grid>
            </Grid>
          </Paper>
        </Grid>

        {/* Mức sử dụng phòng */}
        <Grid item xs={12} md={4}>
          <Paper sx={{ p: 3, height: '100%' }}>
            <Typography variant="h6" gutterBottom>
              Room Utilization
            </Typography>
            <Divider sx={{ mb: 2 }} />
            {roomUtilization.map((item) => (
              <Box key={item.room} sx={{ mb: 2 }}>
                <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                  <Typography variant="body2">{item.room}</Typography>
                  <Typography variant="body2" fontWeight="bold">{item.utilization}%</Typography>
                </Box>
                <LinearProgress
                  variant="determinate"
                  value={item.utilization}
                  sx={{
                    height: 8,
                    borderRadius: 1,
                    backgroundColor: 'grey.200',
                    '& .MuiLinearProgress-bar': {
                      backgroundColor:
                        item.utilization > 70 ? 'success.main' : item.utilization > 50 ? 'info.main' : 'warning.main',
                    },
                  }}
                />
              </Box>
            ))}
          </Paper>
        </Grid>

        {/* Yêu cầu bảo trì gần đây */}
        <Grid item xs={12}>
          <Paper sx={{ p: 3 }}>
            <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 2 }}>
              <Typography variant="h6">Recent Maintenance Requests</Typography>
              <Chip
                label="View All"
                color="primary"
                size="small"
                onClick={() => navigate('/maintenance')}
                sx={{ cursor: 'pointer' }}
              />
            </Box>
            <Divider sx={{ mb: 2 }} />
            <List>
              {maintenanceRequests.map((request) => (
                <React.Fragment key={request.id}>
                  <ListItem
                    secondaryAction={
                      <Chip
                        label={request.status}
                        size="small"
                        color={
                          request.status === 'Completed'
                            ? 'success'
                            : request.status === 'In Progress'
                            ? 'info'
                            : 'warning'
                        }
                      />
                    }
                  >
                    <ListItemAvatar>
                      <Avatar sx={{ bgcolor: 'primary.light' }}>
                        <PersonIcon />
                      </Avatar>
                    </ListItemAvatar>
                    <ListItemText
                      primary={`${request.user} - ${request.room}`}
                      secondary={request.issue}
                    />
                  </ListItem>
                  <Divider />
                </React.Fragment>
              ))}
            </List>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default Dashboard;