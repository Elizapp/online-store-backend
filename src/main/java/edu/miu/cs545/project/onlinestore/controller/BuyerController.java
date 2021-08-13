package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.ShoppingCart;
import edu.miu.cs545.project.onlinestore.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @GetMapping("{buyerId}/cartnotcompleted")
    public ResponseEntity<?> getShoppingCartByBuyerNotCompleted(@PathVariable Long buyerId) {
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCartByBuyerNotCompleted(buyerId);
        if (cart.isPresent()) {
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("No Uncompleted ShoppingCart From Buyer", HttpStatus.NO_CONTENT);
    }
}