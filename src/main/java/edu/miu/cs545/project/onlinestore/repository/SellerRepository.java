package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
    public List<Seller> findAll();

    public Seller getSellerById(Long id);

    @Query(value = "SELECT s.products FROM Seller s WHERE s.id = :id")
    List<Product> getProductsBySellerId(@Param("id") Long id);

    public Seller getSellerByUserId(@Param("userId") Long id);
}