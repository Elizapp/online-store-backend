//package edu.miu.cs545.project.onlinestore.controller;
//
//import edu.miu.cs545.project.onlinestore.domain.Buyer;
//import edu.miu.cs545.project.onlinestore.domain.Seller;
//import edu.miu.cs545.project.onlinestore.domain.User;
//import edu.miu.cs545.project.onlinestore.dto.NewUser;
//import edu.miu.cs545.project.onlinestore.service.IBuyerService;
//import edu.miu.cs545.project.onlinestore.service.SellerServiceImpl;
//import edu.miu.cs545.project.onlinestore.service.UserDetailsImpl;
//import edu.miu.cs545.project.onlinestore.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    IBuyerService buyerService;
//
//    @Autowired
//    SellerServiceImpl sellerService;
//
//    @GetMapping({"/current"})
//    public ResponseEntity<?> getCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        return new ResponseEntity<>(userdetails.getUser(), HttpStatus.OK);
//    }
//
//    @GetMapping({"/mysellerinfo"})
//    public ResponseEntity<?> getCurrentSeller() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        List<Seller> sellerList = sellerService.getAll();
//        Optional<Seller> seller = sellerList
//                .stream()
//                .filter(s -> s.getUser().getUsername().compareToIgnoreCase(userdetails.getUsername()) == 0).findFirst();
//        if (seller.isPresent())
//            return new ResponseEntity<>(seller.get(), HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @GetMapping({"/mybuyerinfo"})
//    public ResponseEntity<?> getCurrentBuyer() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        Optional<Buyer> buyer = buyerService.findAll();
//        buyer.stream().filter(x -> x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
//        if (buyer.isPresent())
//            return new ResponseEntity<>(buyer, HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<?> updateSellerProfile(@RequestBody NewUser updateUser) {
//        User user = userDetailsService.updateProfile(updateUser);
//        if (user != null)
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//}