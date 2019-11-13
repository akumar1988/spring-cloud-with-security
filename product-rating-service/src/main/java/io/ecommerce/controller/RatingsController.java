package io.ecommerce.controller;

import io.ecommerce.model.Rating;
import io.ecommerce.model.UserRating;
import io.ecommerce.service.RatingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingServiceI ratingService;

    protected Logger logger = Logger.getLogger(io.ecommerce.controller.RatingsController.class.getName());

    @RequestMapping("/{productId}")
    public Rating getRatingInfo(@PathVariable("productId") String productId) {
        return new Rating(productId, 1);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRatingInfo(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("1235", 5));
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public ResponseEntity<io.ecommerce.repository.dao.Rating> createRating(@Valid @RequestBody io.ecommerce.repository.dao.Rating rating) {
        logger.info("products-rating-service createRating() invoked: " + rating);
        io.ecommerce.repository.dao.Rating ratingRating = ratingService.createRating(rating);
        return new ResponseEntity<io.ecommerce.repository.dao.Rating>(ratingRating, new HttpHeaders(), HttpStatus.OK);
    }
}
