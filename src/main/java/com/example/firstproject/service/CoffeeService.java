package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoffeeService {

    CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public ArrayList<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffee(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }


    public Coffee save(CoffeeDto coffeeDto) {
        Coffee coffee = coffeeDto.toEntity();
        if(coffee.getId() != null){
            return null;
        }
        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, CoffeeDto coffeeDto) {
        // 1. DTO -> 엔티티 변환하기
        Coffee coffee = coffeeDto.toEntity();


        // 2. 타깃 조회하기
        Coffee target = coffeeRepository.findById(coffee.getId()).orElse(null);

        // 3. 잘못된 요청 처리하기
        if (target != null || id != coffee.getId()) {
            return null;
        }

        // 4. 업데이트하기
        target.patch(target);
        return coffeeRepository.save(target);
    }

    public Coffee delete(Long id) {
        Coffee coffee = coffeeRepository.findById(id).orElse(null);

        if (coffee == null) {
            return null;
        }

        coffeeRepository.deleteById(id);
        return coffee;
    }
}
