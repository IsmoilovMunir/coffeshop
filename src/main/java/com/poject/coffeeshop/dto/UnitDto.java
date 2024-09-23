package com.poject.coffeeshop.dto;

import com.poject.coffeeshop.entity.Unit;

public record UnitDto(Long id, String name) {
    public static UnitDto toDto(Unit unit){
        return new UnitDto(unit.getId(), unit.getName());

    }

    public static UnitDto empty(){
        return new UnitDto(null, null);
    }

    public Unit toEntity(){
        return new Unit(id, name);
    }
}
