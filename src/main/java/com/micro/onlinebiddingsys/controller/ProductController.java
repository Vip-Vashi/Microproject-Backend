package com.micro.onlinebiddingsys.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.micro.onlinebiddingsys.model.Product;
import com.micro.onlinebiddingsys.model.User;
import com.micro.onlinebiddingsys.service.ProductService;
import com.micro.onlinebiddingsys.service.UserService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @PutMapping("/bid")
    public void bidProduct(@RequestParam("productId") int productId,@RequestParam("userId")  int userID,@RequestParam("currentBiddingPrice") Double currentBiddingPrice) {
       
        productService.placebid(productId,userID,currentBiddingPrice);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        return productService.updateProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/create")
    public void createProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("productstatus") String productStatus,
            @RequestParam("startingPrice") Double startingPrice,
            @RequestParam("auctionStartTimeDate") String auctionStartTimeDate,
            @RequestParam("endTimeDate") String endTimeDate,
            @RequestParam("imageBlob") MultipartFile imageBlob,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("user") int user
    ) {
        try {
            byte[] imageBytes = null;
            if (imageBlob != null && !imageBlob.isEmpty()) {
                imageBytes = imageBlob.getBytes();
            }

            User userob = userService.getCustomerById(user);

            LocalDateTime auctionStart = LocalDateTime.parse(auctionStartTimeDate);
            LocalDateTime endTime = LocalDateTime.parse(endTimeDate);

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setProductstatus(productStatus);
            product.setImageBlob(imageBytes);
            product.setImageUrl(imageUrl);
            product.setStartingPrice(startingPrice);
            product.setAuctionStartTimeDate(auctionStart);
            product.setEndTimeDate(endTime);
            product.setCurrentBiddingPrice(null);  // Initially set to null or a default value
            product.setUser(userob);

            productService.createProduct(product);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }

//    @PutMapping("/update/{id}")
//    public void updateProduct(
//            @PathVariable int id,
//            @RequestParam("name") String name,
//            @RequestParam("description") String description,
//            @RequestParam("productstatus") String productStatus,
//            @RequestParam("startingPrice") Double startingPrice,
//            @RequestParam("auctionStartTimeDate") String auctionStartTimeDate,
//            @RequestParam("endTimeDate") String endTimeDate,
//            @RequestParam(value = "imageBlob", required = false) MultipartFile imageBlob,
//            @RequestParam("imageUrl") String imageUrl,
//            @RequestParam("user") int user,
//            @RequestParam("currentBiddingPrice") Double currentBiddingPrice
//    ) {
//        try {
//            Product existingProduct = productService.getProductById(id);
//
//            if (existingProduct != null) {
//                byte[] imageBytes = existingProduct.getImageBlob(); // Retain existing image
//
//                if (imageBlob != null && !imageBlob.isEmpty()) {
//                    imageBytes = imageBlob.getBytes();
//                }
//
//                User userobj = userService.getCustomerById(user);
//
//                LocalDateTime auctionStart = LocalDateTime.parse(auctionStartTimeDate);
//                LocalDateTime endTime = LocalDateTime.parse(endTimeDate);
//
//                existingProduct.setName(name);
//                existingProduct.setDescription(description);
//                existingProduct.setProductstatus(productStatus);
//                existingProduct.setImageBlob(imageBytes);
//                existingProduct.setImageUrl(imageUrl);
//                existingProduct.setStartingPrice(startingPrice);
//                existingProduct.setAuctionStartTimeDate(auctionStart);
//                existingProduct.setEndTimeDate(endTime);
//                existingProduct.setCurrentBiddingPrice(currentBiddingPrice);
//                existingProduct.setUser(userobj);
//
//                productService.updateProduct(existingProduct);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle the error appropriately
//        }
//    }
	
}
