package com.poject.coffeeshop.dto;

import com.poject.coffeeshop.entity.Role;

public record RoleDto(Long id, String name) {
    public Role toEntity() {
        return new Role(id, name);
    }

    public static RoleDto fromEntity(Role role) {
        return role == null
                ? new RoleDto(null, null)
                : new RoleDto(role.getId(), role.getName());
    }
}
