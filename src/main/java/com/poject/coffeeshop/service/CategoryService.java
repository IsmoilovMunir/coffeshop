package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.Category;
import com.poject.coffeeshop.exceptions.EntityNotFoundException;
import com.poject.coffeeshop.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Unit with id %s not found", id)));
    }
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
