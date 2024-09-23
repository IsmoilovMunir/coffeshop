package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.Unit;
import com.poject.coffeeshop.exceptions.EntityNotFoundException;
import com.poject.coffeeshop.repository.UnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public Unit findById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Unit with id %s not found", id)));

    }

    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    public void deleteById(Long id) {
        unitRepository.deleteById(id);

    }
}
