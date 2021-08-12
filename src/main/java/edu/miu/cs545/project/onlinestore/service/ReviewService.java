package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Review;

import java.util.Optional;
import java.util.List;

public interface ReviewService {
    List<Review> getReviewsNotApproved();
    void createReview(Review review);
    Optional<Review> getReviewById(Long reviewId);
    Boolean approveReview(Long reviewId);
}
