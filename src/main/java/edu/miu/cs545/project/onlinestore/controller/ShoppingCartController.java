package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.ShoppingCart;
import edu.miu.cs545.project.onlinestore.domain.ShoppingCartLine;
import edu.miu.cs545.project.onlinestore.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    OrderController orderController;

    //    @Autowired
//    ModelMapper modelMapper;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping()
    public ResponseEntity<?> createShoppingCart(@RequestBody ShoppingCart cart) {
        return new ResponseEntity<>(shoppingCartService.createShoppingCart(cart), HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getShoppingCart(@PathVariable Long cartId) {
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCart(cartId);
        if (cart.isPresent()) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cart does not exist", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{cartId}/cartlines")
    public ResponseEntity<?> getLinesFromShoppingCart(@PathVariable Long cartId) {
        return new ResponseEntity<>(shoppingCartService.getLinesByShoppingCart(cartId), HttpStatus.OK);
    }

    // add line to shopping cart
    @PostMapping("/{cartId}/cartlines")
    public void addLineToShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCartLine cartLine) {
        shoppingCartService.addLineToShoppingCart(cartId, cartLine);
    }

    // update line in shopping cart
    @PutMapping("/{cartId}/cartlines")
    public ResponseEntity<?> updateLineInShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCartLine cartLine) {
        shoppingCartService.updateLineInShoppingCart(cartId, cartLine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // update quantity in shopping cart
    @PutMapping("/{cartId}/cartlines/{lineId}")
    public ResponseEntity<?> updateLineInShoppingCart(@PathVariable Long cartId, @PathVariable Long lineId, @RequestBody Integer newQuantity) {
        shoppingCartService.updateQuantityInShoppingCartLine(cartId, lineId, newQuantity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // remove line from shopping cart
    @DeleteMapping("/{cartId}/cartlines/{cartLineId}")
    public ResponseEntity<?> removeLineToShoppingCart(@PathVariable Long cartId, @PathVariable Long cartLineId) {
        shoppingCartService.removeLineFromShoppingCart(cartId, cartLineId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


//    @PostMapping("/{cartId}/createorder")
//    public void createOrder(@PathVariable Long cartId, @RequestBody ShippingAndPayment shippingAndPayment) {
//        orderController.createOrderFromCart(cartId, shippingAndPayment.shipping, shippingAndPayment.payment);
////        return orderService.createOrder(order);
//    }   //checked


}


