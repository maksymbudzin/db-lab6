package com.budzin.service;

import com.budzin.domain.Feedback;
import com.budzin.domain.Rating;
import com.budzin.repository.FeedbackRepository;
import com.budzin.repository.RatingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements AbstractService<Feedback, Integer> {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getById(Integer id) {
        return feedbackRepository.getOne(id);
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback  update(Integer id, Feedback feedback) {
        if (feedbackRepository.findById(id).isPresent()) {
            return feedbackRepository.save(feedback);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (feedbackRepository.findById(id).isPresent()) {
            feedbackRepository.deleteById(id);
        }
    }
}