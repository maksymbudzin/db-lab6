package com.budzin.controller;

import com.budzin.domain.TripAdvizor_object;
import com.budzin.dto.TripAdvizor_objectDto;
import com.budzin.dto.Trip_OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.TripAdvizor_objectService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/TripAdvizor_object")
@RestController
public class TripAdvizor_objectController {
    private final TripAdvizor_objectService tripAdvizor_objectService;

    public TripAdvizor_objectController(TripAdvizor_objectService tripAdvizor_objectService) {
        this.tripAdvizor_objectService = tripAdvizor_objectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TripAdvizor_objectDto>> getAll() {
        List<TripAdvizor_object> tripAdvizor_objects = tripAdvizor_objectService.getAll();
        List<TripAdvizor_objectDto> tripAdvizor_objectDtos = new ArrayList<>();
        for (TripAdvizor_object tripAdvizor_object : tripAdvizor_objects) {
            TripAdvizor_objectDto tripAdvizor_objectDto = new TripAdvizor_objectDto(
                    tripAdvizor_object.getId(),
                    tripAdvizor_object.getObjec_name(),
                    tripAdvizor_object.getNumber_of_star(),
                    tripAdvizor_object.getFree_room(),
                    tripAdvizor_object.getBusy_room(),
                    tripAdvizor_object.getAll_inclusive(),
                    tripAdvizor_object.getUltra_all_inclusive()
            );
            tripAdvizor_objectDtos.add(tripAdvizor_objectDto);
        }
        return new ResponseEntity<>(tripAdvizor_objectDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<TripAdvizor_objectDto> getById(@PathVariable Integer id) {
        TripAdvizor_object tripAdvizor_object = tripAdvizor_objectService.getById(id);
        if (tripAdvizor_object != null) {
            TripAdvizor_objectDto tripAdvizor_objectDto = new TripAdvizor_objectDto(
                    tripAdvizor_object.getId(),
                    tripAdvizor_object.getObjec_name(),
                    tripAdvizor_object.getNumber_of_star(),
                    tripAdvizor_object.getFree_room(),
                    tripAdvizor_object.getBusy_room(),
                    tripAdvizor_object.getAll_inclusive(),
                    tripAdvizor_object.getUltra_all_inclusive()
            );
            return new ResponseEntity<>(tripAdvizor_objectDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody TripAdvizor_object newTripAdvizor_object) {
        tripAdvizor_objectService.create(newTripAdvizor_object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TripAdvizor_objectDto> update(@PathVariable Integer id,
                                              @RequestBody TripAdvizor_object tripAdvizor_object) {
        TripAdvizor_object tripAdvizor_object1 = tripAdvizor_objectService.getById(id);
        if (tripAdvizor_object1 != null) {
            tripAdvizor_objectService.update(id, tripAdvizor_object);
            TripAdvizor_objectDto tripAdvizor_objectDto = new TripAdvizor_objectDto(
                    tripAdvizor_object.getId(),
                    tripAdvizor_object.getObjec_name(),
                    tripAdvizor_object.getNumber_of_star(),
                    tripAdvizor_object.getFree_room(),
                    tripAdvizor_object.getBusy_room(),
                    tripAdvizor_object.getAll_inclusive(),
                    tripAdvizor_object.getUltra_all_inclusive()
            );
            return new ResponseEntity<>(tripAdvizor_objectDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (tripAdvizor_objectService.getById(id) != null) {
            tripAdvizor_objectService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
