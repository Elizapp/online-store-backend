package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Seller;
import edu.miu.cs545.project.onlinestore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Boolean approveSeller(long id) {
        Optional<Seller> approvedSeller = sellerRepository.getSellerById(id);
        if (approvedSeller.isPresent()) {
            Seller seller = approvedSeller.get();
            seller.getUser().setEnabled(true);
            seller.setApproved(true);
            sellerRepository.save(seller);
            return true;
        }
        return false;
    }
}
