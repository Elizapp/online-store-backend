package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Buyer;
import edu.miu.cs545.project.onlinestore.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    BuyerRepository buyerRepository;
    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findBuyerById(Long id) {
        return buyerRepository.findBuyerById(id);
    }
}
