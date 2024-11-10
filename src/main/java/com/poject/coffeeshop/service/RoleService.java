package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.Role;
import com.poject.coffeeshop.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
}
