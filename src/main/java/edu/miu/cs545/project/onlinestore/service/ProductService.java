package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Long id);

    Boolean createProduct(Product product, Long id);
    void deleteProduct(Long id);
    Boolean updateProduct(Product product, Long id);
    List<Review> getApprovedReviewsByProductId(Long id);
    List<Product> getAll();
}
