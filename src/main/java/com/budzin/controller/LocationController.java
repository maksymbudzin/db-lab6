package com.budzin.controller;
import com.budzin.domain.Location;
import com.budzin.dto.LocationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.LocationService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Location")
@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LocationDto>> getAll() {
        List<Location> locations = locationService.getAll();
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locations) {
            LocationDto locationDto = new LocationDto(
                    location.getId(),
                    location.getCountry(),
                    location.getCity()

            );
            locationDtos.add(locationDto);
        }
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<LocationDto> getById(@PathVariable Integer id) {
        Location location = locationService.getById(id);
        if (location != null) {
            LocationDto locationDto = new LocationDto(
                    location.getId(),
                    location.getCountry(),
                    location.getCity()

            );
            return new ResponseEntity<>(locationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Location newLocation) {
        locationService.create(newLocation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LocationDto> update(@PathVariable Integer id,
                                                       @RequestBody Location location) {
        Location location1 = locationService.getById(id);
        if (location1 != null) {
            locationService.update(id, location);
            LocationDto locationDto = new LocationDto(
                    location.getId(),
                    location.getCountry(),
                    location.getCity()

            );
            return new ResponseEntity<>(locationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (locationService.getById(id) != null) {
            locationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}