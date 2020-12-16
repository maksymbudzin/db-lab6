package com.budzin.service;

import com.budzin.domain.TripAdvizor_object;
import com.budzin.repository.TripAdvizor_objectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripAdvizor_objectService implements AbstractService<TripAdvizor_object, Integer> {

    private final TripAdvizor_objectRepository tripAdvizor_objectRepository;

    public TripAdvizor_objectService(TripAdvizor_objectRepository tripAdvizor_objectRepository) {
        this.tripAdvizor_objectRepository = tripAdvizor_objectRepository;
    }


    @Override
    public List<TripAdvizor_object> getAll() {
        return tripAdvizor_objectRepository.findAll();
    }

    @Override
    public TripAdvizor_object getById(Integer id) {
        return tripAdvizor_objectRepository.getOne(id);
    }

    @Override
    public TripAdvizor_object create(TripAdvizor_object tripAdvizor_object) {
        return tripAdvizor_objectRepository.save(tripAdvizor_object);
    }

    @Override
    public TripAdvizor_object update(Integer id, TripAdvizor_object tripAdvizor_object) {
        if (tripAdvizor_objectRepository.findById(id).isPresent()) {
            return tripAdvizor_objectRepository.save(tripAdvizor_object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (tripAdvizor_objectRepository.findById(id).isPresent()) {
            tripAdvizor_objectRepository.deleteById(id);
        }
    }

}