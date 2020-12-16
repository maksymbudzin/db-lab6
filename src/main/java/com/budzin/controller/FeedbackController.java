package com.budzin.controller;
import com.budzin.domain.Feedback;
import com.budzin.dto.FeedbackDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.budzin.service.FeedbackService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Feedback")
@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FeedbackDto>> getAll() {
        List<Feedback> feedbacks = feedbackService.getAll();
        List<FeedbackDto> feedbackDtos = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            FeedbackDto feedbackDto = new FeedbackDto(
                    feedback.getId(),
                    feedback.getFeedback_text(),
                    feedback.getTime(),
                    feedback.getCustomer_id(),
                    feedback.getCustomer_Trip_Order_id()
            );
            feedbackDtos.add(feedbackDto);
        }
        return new ResponseEntity<>(feedbackDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<FeedbackDto> getById(@PathVariable Integer id) {
        Feedback feedback = feedbackService.getById(id);
        if (feedback != null) {
            FeedbackDto feedbackDto = new FeedbackDto(
                    feedback.getId(),
                    feedback.getFeedback_text(),
                    feedback.getTime(),
                    feedback.getCustomer_id(),
                    feedback.getCustomer_Trip_Order_id()
            );
            return new ResponseEntity<>(feedbackDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Feedback newFeedback) {
        feedbackService.create(newFeedback);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FeedbackDto> update(@PathVariable Integer id,
                                              @RequestBody Feedback feedback) {
        Feedback feedback1 = feedbackService.getById(id);
        if (feedback1 != null) {
            feedbackService.update(id, feedback);
            FeedbackDto feedbackDto = new FeedbackDto(
                    feedback.getId(),
                    feedback.getFeedback_text(),
                    feedback.getTime(),
                    feedback.getCustomer_id(),
                    feedback.getCustomer_Trip_Order_id()
            );
            return new ResponseEntity<>(feedbackDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (feedbackService.getById(id) != null) {
            feedbackService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}