package edu.miu.cs545.project.onlinestore.repository;

import edu.miu.cs545.project.onlinestore.domain.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long> {
    List<Buyer> findAll();
    Buyer findBuyerById(Long id);
}
