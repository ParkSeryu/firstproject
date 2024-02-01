package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {

    private final CoffeeService coffeeService;

    public CoffeeApiController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeService.findAll();
    }

    @GetMapping("/api/coffees/{id}")
    public Coffee getCoffeeOnlyOne(@PathVariable Long id) {
        return coffeeService.getCoffee(id);
    }

    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto coffeeDto) {
        Coffee target = coffeeService.save(coffeeDto);
        return target == null ?
                ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> patchCoffee(@PathVariable Long id, @RequestBody CoffeeDto coffeeDto) {
        Coffee coffee = coffeeService.update(id, coffeeDto);
        return coffee == null ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) :
                ResponseEntity.status(HttpStatus.OK).body(coffee);
    }

    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> deleteCoffee(@PathVariable Long id) {

        Coffee coffee = coffeeService.delete(id);

        return coffee != null ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
