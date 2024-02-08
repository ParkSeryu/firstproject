package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    public Pizza(PizzaDto pizzaDto) {
        this.id = pizzaDto.getId();
        this.name = pizzaDto.getName();
        this.price = pizzaDto.getPrice();
    }

    public void update(PizzaDto pizzaDto) {
        this.name = pizzaDto.getName();
        this.price = pizzaDto.getPrice();
    }
}
