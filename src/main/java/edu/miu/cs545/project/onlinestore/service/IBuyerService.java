package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Buyer;

import java.util.Optional;

public interface IBuyerService {
    Optional<Buyer> findAll();

    Optional<Buyer> findBuyerById(Long id);
}
