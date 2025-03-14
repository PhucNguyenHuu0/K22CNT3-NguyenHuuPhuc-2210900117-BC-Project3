package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.model.Location;
import com.nhp.university.facilitymanagement.repository.LocationRepository;
import com.nhp.university.facilitymanagement.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa điểm!"));
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location updatedLocation) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setBuilding(updatedLocation.getBuilding());
                    location.setFloor(updatedLocation.getFloor());
                    return locationRepository.save(location);
                })
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa điểm!"));
    }

    @Override
    public void deleteLocation(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new RuntimeException("Địa điểm không tồn tại!");
        }
        locationRepository.deleteById(id);
    }
}
