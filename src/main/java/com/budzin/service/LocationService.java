package com.budzin.service;

import com.budzin.domain.Location;
import com.budzin.domain.Rating;
import com.budzin.repository.LocationRepository;
import com.budzin.repository.RatingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements AbstractService<Location, Integer> {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location getById(Integer id) {
        return locationRepository.getOne(id);
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Integer id, Location location) {
        if (locationRepository.findById(id).isPresent()) {
            return locationRepository.save(location);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
        }
    }
}
