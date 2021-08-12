package edu.miu.cs545.project.onlinestore.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Override
    public Boolean approveSeller(long id) {
        return null;
    }
    //@Autowired
    //SellerRepository sellerRepository;

//    @Override
//    public Boolean approveSeller(long id) {
//        Seller seller = sellerRepository.getSellerById(id);
//        if(seller != null){
//            seller.getUser().setEnabled(true);
//            seller.setApproved(true);
//            sellerRepository.save(seller);
//            return true;
//        }
//        return false;
//    }
}
