package com.budzin.service;

import com.budzin.domain.Rating;
import com.budzin.domain.Trip_Order;
import com.budzin.repository.RatingRepository;
import com.budzin.repository.Trip_OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements AbstractService<Rating, Integer> {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(Integer id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating update(Integer id, Rating rating) {
        if (ratingRepository.findById(id).isPresent()) {
            return ratingRepository.save(rating);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (ratingRepository.findById(id).isPresent()) {
            ratingRepository.deleteById(id);
        }
    }

}