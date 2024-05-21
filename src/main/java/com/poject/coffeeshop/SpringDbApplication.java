package com.poject.coffeeshop;

import com.poject.coffeeshop.entity.Product;
import com.poject.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDbApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDbApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
//        Product product = new Product(null, "name");
//        repository.save(product);
//        List<Product> all = repository.findAll();
//        System.out.println(all);
    }



}
