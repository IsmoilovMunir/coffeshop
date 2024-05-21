package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.Product;
import com.poject.coffeeshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;
    public List<Product> getAll(){
        log.info("get All");
        return repository.findAll();
    }
    public Product getById(Long id){
        log.info("get by ID" + id);
        return repository.findById(id).orElse(null);
    }
    public void create (Product product){
        log.info("Create");
       repository.save(product);
    }

    public void update(Product product){
        log.info("Update ");
        repository.save(product);
    }

    public void delete(Integer id){
        log.info("Delete "+ id);
        repository.deleteById(Long.valueOf(id));
    }
}
