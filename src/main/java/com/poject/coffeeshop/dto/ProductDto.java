package com.poject.coffeeshop.dto;

import com.poject.coffeeshop.entity.Product;

public record ProductDto (Long id, String name, String description){


    public  static ProductDto fromProduct(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getDescription());
    }
    public Product toEntity (){
        return new Product(id, name, description);
    }
}
