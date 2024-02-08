package com.example.firstproject.service;


import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    public List<Pizza> getAllPizza(){
        return pizzaRepository.findAll();
    }

    public Pizza getPizza(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 ID가 없습니다."));
    }

    @Transactional
    public PizzaDto create(PizzaDto pizzaDto) {
        Pizza pizza = new Pizza(pizzaDto);
        Pizza createPizza = pizzaRepository.save(pizza);
        return PizzaDto.createPizzaDto(createPizza);
    }

    @Transactional
    public PizzaDto patchPizza(Long id, PizzaDto pizzaDto) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 피자가 없습니다."));
        pizza.update(pizzaDto);
        pizzaRepository.save(pizza);
        return PizzaDto.createPizzaDto(pizza);
    }

    public PizzaDto deletePizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 피자가 엄습니다"));
        pizzaRepository.deleteById(id);
        return PizzaDto.createPizzaDto(pizza);
    }
}
