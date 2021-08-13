package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import edu.miu.cs545.project.onlinestore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Optional<Seller> getSellerByID(Long id) {
        return sellerRepository.getSellerById(id);
    }

    @Override
    public List<Product> getProductsBySellerId(Long id) {
        return sellerRepository.getProductsBySellerId(id);
    }


}