package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PizzaDto {
    private Long id;
    private String name;
    private Integer price;

    public static PizzaDto createPizzaDto(Pizza createPizza) {
        return new PizzaDto(createPizza.getId(), createPizza.getName(), createPizza.getPrice());
    }
}
