package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.MenuItem;
import com.poject.coffeeshop.exceptions.EntityNotFoundException;
import com.poject.coffeeshop.repository.MenuItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findAll(){
        return menuItemRepository.findAll();
    }

    public MenuItem findById(Long id){
        return menuItemRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("MenuItem with id %s not found", id)));
    }

    public MenuItem save(MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public void deleteById(Long id){
        menuItemRepository.deleteById(id);
    }

}
