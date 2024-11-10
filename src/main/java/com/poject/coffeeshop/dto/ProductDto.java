package com.poject.coffeeshop.dto;


import com.poject.coffeeshop.entity.Category;
import com.poject.coffeeshop.entity.Product;

import java.util.Optional;

public record ProductDto(Long id, String name, String description, CategoryDto category) {


    public static ProductDto empty() {
        return new ProductDto(null, null, null, null);
    }

    public static ProductDto toDto(Product product) {
        CategoryDto category = Optional.ofNullable(product.getCategory())
                .map(CategoryDto::from)
                .orElse(CategoryDto.empty());
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                category
        );

    }

    public Product toEntity() {

        Category categoryEntity = Optional.ofNullable(category)
                .map(CategoryDto::toEntity)
                .orElse(new Category());
        return new Product(id, name, description, categoryEntity);
    }
}
