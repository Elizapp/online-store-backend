package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    Optional<Review> findById(long reviewId);
    Review save(Review review);

    @Query(value = "SELECT r FROM Review r WHERE r.approved = false")
    List<Review> getReviewsNotApproved();

}