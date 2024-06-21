package com.poject.coffeeshop;

import com.poject.coffeeshop.entity.Product;
import com.poject.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDbApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDbApplication.class, args);


    }
}
