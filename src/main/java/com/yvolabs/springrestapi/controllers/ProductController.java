package com.yvolabs.springrestapi.controllers;

import com.yvolabs.springrestapi.entities.Product;
import com.yvolabs.springrestapi.services.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductJpaRepository productService;

    public ProductController(ProductJpaRepository productService) {
        this.productService = productService;
    }

    @GetMapping("/welcome")
    public String sayHi(){
        return "welcome to product page !!!!!!!!!!";
    }

    //Jackson will converts POJO's into json format
    @GetMapping("/product")
    public Product getProduct(){
        Product product = new Product(1,"productA",10);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productService.findAll();
//        List<Product> products = new ArrayList<>();
//
//        Product product1 = new Product(1,"productA",10);
//        Product product2 = new Product(2,"productB",20);
//        Product product3 = new Product(3,"productC",30);
//
//        products.add(product1);
//        products.add(product2);
//        products.add(product3);
//
//        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.findById(id).get();
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable int id){
        productService.deleteById(id);
        return "Product deleted";
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product){

        return productService.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        productService.findById(id).map(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            return productService.save(p);
        });

        return product;
    }

}
