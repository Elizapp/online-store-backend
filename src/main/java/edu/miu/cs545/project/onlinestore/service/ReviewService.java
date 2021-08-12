package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    void createReview(Review review);
    Optional<Review> getReviewById(Long reviewId);
    List<Review> getReviewsNotApproved();
    Boolean approveReview(Long reviewId);
}
