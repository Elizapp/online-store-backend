package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Review;
import edu.miu.cs545.project.onlinestore.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    @PostMapping()
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        reviewService.createReview(review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    @ResponseBody
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId) {
        Optional<Review> reviewOptional = reviewService.getReviewById(reviewId);
        if (reviewOptional.isPresent()) {
            return new ResponseEntity<>(reviewOptional.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/notapproved")
    public @ResponseBody
    ResponseEntity<?> getReviewsNotApproved() {
        Collection<Review> reviews = reviewService.getReviewsNotApproved();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}/approve")
    public ResponseEntity<?> approveReview(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.approveReview(reviewId), HttpStatus.CREATED);
    }
}