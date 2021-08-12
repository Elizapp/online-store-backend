package edu.miu.cs545.project.onlinestore.controller;


import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Review;
import edu.miu.cs545.project.onlinestore.dto.ProductDTO;
import edu.miu.cs545.project.onlinestore.dto.ReviewDTO;
import edu.miu.cs545.project.onlinestore.service.ProductService;
import edu.miu.cs545.project.onlinestore.service.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;



    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/{productId}")
    public @ResponseBody ProductDTO getProductById(@PathVariable Long productId){
        Optional<Product> productOptional = productService.getProductById(productId);
        if(productOptional.isPresent()){
            return modelMapper.map(productOptional.get(), ProductDTO.class);
        }
        return null;
    }

    @GetMapping("")
    public @ResponseBody
    List<ProductDTO> getAllProducts(){
        List<Product> products = productService.getAll();
        return products.stream()
                .map(p -> modelMapper.map(p,ProductDTO.class))
                .collect(Collectors.toList());
    }


    @PostMapping("/new")
    @PreAuthorize("hasAutority('SELLER')")
    public Boolean createProduct(@RequestBody ProductDTO productDTO){
        System.out.println(productDTO);
        Product product = modelMapper.map(productDTO, Product.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userdetails);
        return productService.createProduct(product, userdetails.getUser().getId());
    }

    @PutMapping("")
    public void updateProduct(@RequestBody ProductDTO productDTO){
        Product product = modelMapper.map(productDTO, Product.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) authentication.getPrincipal();
        productService.updateProduct(product, userdetails.getUser().getId());
    }


    @DeleteMapping(value = "/{productId}")
    public Boolean deleteProduct(@PathVariable Long productId) throws Exception {
        Optional<Product> product =  productService.getProductById(productId);
        try{
            if(product.isPresent()){
                productService.deleteProduct(productId);
                return true;
            } else{
                throw new EntityNotFoundException("Product doesn't exist");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    //Get approved reviews by product id
    @GetMapping("{productId}/reviews")
    public @ResponseBody
    List<ReviewDTO> getApprovedReviewsByProductId(@PathVariable Long productId){
        List<Review> reviews = productService.getApprovedReviewsByProductId(productId);
        return reviews.stream()
                .map(review->modelMapper.map(review,ReviewDTO.class))
                .collect(Collectors.toList());
    }

}
