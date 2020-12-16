package com.budzin.controller;

import com.budzin.domain.Trip_Order;
import com.budzin.dto.Trip_OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.Trip_OrderService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Trip_Order")
@RestController
public class Trip_OrderController {
    private final Trip_OrderService trip_orderService;

    public Trip_OrderController(Trip_OrderService trip_orderService) {
        this.trip_orderService = trip_orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Trip_OrderDto>> getAll() {
        List<Trip_Order> trip_orders = trip_orderService.getAll();
        List<Trip_OrderDto> trip_orderDtos = new ArrayList<>();
        for (Trip_Order trip_order : trip_orders) {
            Trip_OrderDto trip_orderDto = new Trip_OrderDto(
                    trip_order.getId(),
                    trip_order.getPrice_in_dollars(),
                    trip_order.getDate(),
                    trip_order.getCustomer_id()

            );
            trip_orderDtos.add(trip_orderDto);
        }
        return new ResponseEntity<>(trip_orderDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Trip_OrderDto> getById(@PathVariable Integer id) {
        Trip_Order trip_order = trip_orderService.getById(id);
        if (trip_order != null) {
            Trip_OrderDto trip_orderDto = new Trip_OrderDto(
                    trip_order.getId(),
                    trip_order.getPrice_in_dollars(),
                    trip_order.getDate(),
                    trip_order.getCustomer_id()

            );
            return new ResponseEntity<>(trip_orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Trip_Order newtrip_order) {
        trip_orderService.create(newtrip_order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Trip_OrderDto> update(@PathVariable Integer id,
                                                        @RequestBody Trip_Order trip_order) {
        Trip_Order trip_order1 = trip_orderService.getById(id);
        if (trip_order1 != null) {
            trip_orderService.update(id, trip_order);
            Trip_OrderDto trip_orderDto = new Trip_OrderDto(
                    trip_order.getId(),
                    trip_order.getPrice_in_dollars(),
                    trip_order.getDate(),
                    trip_order.getCustomer_id()

            );
            return new ResponseEntity<>(trip_orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (trip_orderService.getById(id) != null) {
            trip_orderService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}