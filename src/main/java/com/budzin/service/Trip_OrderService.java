package com.budzin.service;

import com.budzin.domain.TripAdvizor_object;
import com.budzin.domain.Trip_Order;
import com.budzin.repository.TripAdvizor_objectRepository;
import com.budzin.repository.Trip_OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Trip_OrderService implements AbstractService<Trip_Order, Integer> {

    private final Trip_OrderRepository trip_orderRepository;

    public Trip_OrderService(Trip_OrderRepository trip_orderRepository) {
        this.trip_orderRepository = trip_orderRepository;
    }

    @Override
    public List<Trip_Order> getAll() {
        return trip_orderRepository.findAll();
    }

    @Override
    public Trip_Order getById(Integer id) {
        return trip_orderRepository.getOne(id);
    }

    @Override
    public Trip_Order create(Trip_Order trip_order) {
        return trip_orderRepository.save(trip_order);
    }

    @Override
    public Trip_Order update(Integer id, Trip_Order trip_order) {
        if (trip_orderRepository.findById(id).isPresent()) {
            return trip_orderRepository.save(trip_order);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (trip_orderRepository.findById(id).isPresent()) {
            trip_orderRepository.deleteById(id);
        }
    }

}