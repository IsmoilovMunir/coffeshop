package com.poject.coffeeshop.repository;

import com.poject.coffeeshop.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
