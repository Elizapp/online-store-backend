package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
    List<Seller> findAll();

    Optional<Seller> getSellerById(Long id);

    @Query(value = "SELECT s.products FROM Seller s WHERE s.id = :id")
    List<Product> getProductsBySellerId(@Param("id") Long id);

    Seller getSellerByUserId(@Param("userId") Long id);
}