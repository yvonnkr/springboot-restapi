package com.yvolabs.springrestapi.controllers;

import com.yvolabs.springrestapi.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

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
        List<Product> products = new ArrayList<>();

        Product product1 = new Product(1,"productA",10);
        Product product2 = new Product(2,"productB",20);
        Product product3 = new Product(3,"productC",30);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }

}
