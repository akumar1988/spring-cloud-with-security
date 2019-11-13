package io.ecommerce.service.impl;

import io.ecommerce.repository.RatingRepository;
import io.ecommerce.repository.dao.Rating;
import io.ecommerce.service.RatingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService implements RatingServiceI {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating entity) {
        Optional<Rating> rating = ratingRepository.findById(entity.getId());
        if (rating.isPresent()) {
            Rating ratingDetails = rating.get();
            ratingDetails.setRatingPoint(entity.getRatingPoint());
            ratingDetails = ratingRepository.save(ratingDetails);
            return ratingDetails;
        } else {
            entity = ratingRepository.save(entity);
            System.out.println(entity);
            return entity;
        }
    }
}
