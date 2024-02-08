package com.example.firstproject.api;


import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PizzaApiController {
    private PizzaService pizzaService;

    public PizzaApiController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/api/pizza")
    private List<Pizza> getAllPizza(){
        return pizzaService.getAllPizza();
    }

    @GetMapping("/api/pizza/{id}")
    private Pizza getPizza(@PathVariable Long id){
        return pizzaService.getPizza(id);
    }

    @PostMapping("/api/pizza/new")
    private ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto){
        PizzaDto createPizzaDto = pizzaService.create(pizzaDto);
        return ResponseEntity.status(HttpStatus.OK).body(createPizzaDto);
    }

    @PatchMapping("/api/pizza/{id}")
    private ResponseEntity<PizzaDto> patchPizza(@PathVariable Long id, @RequestBody PizzaDto pizzaDto){
        PizzaDto p = pizzaService.patchPizza(id, pizzaDto);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @DeleteMapping("/api/pizza/{id}")
    private ResponseEntity<PizzaDto> deletePizza(@PathVariable Long id){
        PizzaDto p = pizzaService.deletePizza(id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

}
