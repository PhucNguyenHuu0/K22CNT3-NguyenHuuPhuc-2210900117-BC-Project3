package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Location;
import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocationById(Long id);
    Location createLocation(Location location);
    Location updateLocation(Long id, Location updatedLocation);
    void deleteLocation(Long id);
}
