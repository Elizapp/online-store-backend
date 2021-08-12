package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Review;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import edu.miu.cs545.project.onlinestore.repository.ProductRepository;
import edu.miu.cs545.project.onlinestore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Boolean createProduct(Product product, Long userId) {
        try {
            Seller seller = sellerRepository.getSellerByUserId(userId);
            if(seller != null){
                product.setSeller(seller);
                productRepository.save(product);
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Review> getApprovedReviewsByProductId(Long productId) {
        List<Review> reviews = productRepository.findReviewsByProductId(productId);
        return reviews.stream().filter(r->r.isApproved()).collect(Collectors.toList());
    }

    @Override
    public Boolean updateProduct(Product product, Long userId) {
        try {
            Seller seller = sellerRepository.getSellerByUserId(userId);
            if(seller != null){
                product.setSeller(seller);
                productRepository.save(product);
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }
}
