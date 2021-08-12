package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Buyer;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import edu.miu.cs545.project.onlinestore.domain.User;
import edu.miu.cs545.project.onlinestore.dto.*;
import edu.miu.cs545.project.onlinestore.service.BuyerService;
import edu.miu.cs545.project.onlinestore.service.SellerServiceImpl;
import edu.miu.cs545.project.onlinestore.service.UserDetailsImpl;
import edu.miu.cs545.project.onlinestore.service.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    SellerServiceImpl sellerService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping({ "/current" })
    public @ResponseBody
    UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
        return modelMapper.map(userdetails.getUser(), UserDTO.class);
    }
    @GetMapping({ "/mysellerinfo" })
    public @ResponseBody
    SellerDTO getCurrentSeller() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
        List<Seller> sellerList  = sellerService.getAll();
        Optional<Seller> seller = sellerList
                .stream()
                .filter(s -> s.getUser().getUsername().compareToIgnoreCase(userdetails.getUsername()) == 0).findFirst();
        if(seller.isPresent())
            return modelMapper.map(seller.get(), SellerDTO.class);
        return null;
    }

    @GetMapping({ "/mybuyerinfo" })
    public @ResponseBody
    BuyerDTO getCurrentBuyer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
        Optional<Buyer> buyer =  buyerService.findAll().stream().filter(x->x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
        if(buyer.isPresent())
            return modelMapper.map(buyer.get(), BuyerDTO.class);
        return null;
    }

    @PostMapping("/update")
    public @ResponseBody  UserDTO updateSellerProfile(@RequestBody NewUserDTO updateUser){
        User user = userDetailsService.updateProfile(updateUser);
        if(user != null)
            return modelMapper.map(user, UserDTO.class);
        return null;
    }

}

