package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;

import java.util.List;
public interface SellerService {
    List<Seller> getAll();
    Seller getSellerByID(Long id);
    List<Product> getProductsBySellerId(Long id);
}
