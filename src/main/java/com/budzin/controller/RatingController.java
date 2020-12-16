package com.budzin.controller;

import com.budzin.domain.Rating;
import com.budzin.dto.RatingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.RatingService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Rating")
@RestController
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RatingDto>> getAll() {
        List<Rating> ratings = ratingService.getAll();
        List<RatingDto> ratingDtos = new ArrayList<>();
        for (Rating rating : ratings) {
            RatingDto ratingDto = new RatingDto(
                    rating.getId(),
                    rating.getNumber_of_star(),
                    rating.getDate(),
                    rating.getCustomer_id(),
                    rating.getCustomer_Trip_Order_id()

            );
            ratingDtos.add(ratingDto);
        }
        return new ResponseEntity<>(ratingDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<RatingDto> getById(@PathVariable Integer id) {
        Rating rating = ratingService.getById(id);
        if (rating != null) {
            RatingDto ratingDto = new RatingDto(
                    rating.getId(),
                    rating.getNumber_of_star(),
                    rating.getDate(),
                    rating.getCustomer_id(),
                    rating.getCustomer_Trip_Order_id()

            );
            return new ResponseEntity<>(ratingDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Rating newRating) {
        ratingService.create(newRating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RatingDto> update(@PathVariable Integer id,
                                                @RequestBody Rating rating) {
        Rating rating1 = ratingService.getById(id);
        if (rating1 != null) {
            ratingService.update(id, rating);
            RatingDto ratingDto = new RatingDto(
                    rating.getId(),
                    rating.getNumber_of_star(),
                    rating.getDate(),
                    rating.getCustomer_id(),
                    rating.getCustomer_Trip_Order_id()

            );
            return new ResponseEntity<>(ratingDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (ratingService.getById(id) != null) {
            ratingService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}