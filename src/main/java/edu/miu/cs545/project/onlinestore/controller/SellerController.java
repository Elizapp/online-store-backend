package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Order;
import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;
import edu.miu.cs545.project.onlinestore.service.IOrderService;
import edu.miu.cs545.project.onlinestore.service.IProductService;
import edu.miu.cs545.project.onlinestore.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    ISellerService sellerService;
    @Autowired
    IOrderService orderService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        Collection<Seller> sellers = sellerService.getAll();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/notapproved")
    public ResponseEntity<?> getNotApprovedSellers() {
        Collection<Seller> sellers = sellerService.getAll();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSellerById(@PathVariable("id") Long id) {
        Optional<Seller> seller = sellerService.getSellerByID(id);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    //Get products by seller
    @GetMapping("/{id}/products")
    public ResponseEntity<?> getProductsBySellerId(@PathVariable("id") Long id) {
        Collection<Product> products = sellerService.getProductsBySellerId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getOrdersBySellerId(@PathVariable("id") Long id) {
        Collection<Order> orders = orderService.getOrderBySellerId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}/cancel")
    public @ResponseBody
    ResponseEntity<?> cancelOrder(@PathVariable long orderId) {
        boolean b = orderService.cancelOrder(orderId);
        if (b) return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{orderId}/shipped")
    public @ResponseBody
    ResponseEntity<?> shippedOrder(@PathVariable long orderId) {
        boolean b = orderService.shippedOrder(orderId);
        if (b) return new ResponseEntity<>(b, HttpStatus.OK);
        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{orderId}/delivered")
    public @ResponseBody
    ResponseEntity<?> deliveredOrder(@PathVariable long orderId) {
        boolean b = orderService.deliveredOrder(orderId);
        if (b) return new ResponseEntity<>(b, HttpStatus.OK);
        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/newproduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        boolean b = productService.createProduct(product);
        if (b) return new ResponseEntity<>(b, HttpStatus.CREATED);
        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/updateproduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        boolean b = productService.createProduct(product);
        if (b) return new ResponseEntity<>(b, HttpStatus.CREATED);
        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }
}
