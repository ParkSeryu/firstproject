package com.example.firstproject.entity;

import com.example.firstproject.dto.CoffeeDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    public void patch(Coffee coffee){
        if(coffee.getName() != null){
            this.name = coffee.getName();
        }
        if(coffee.getPrice() != null){
            this.price = coffee.getPrice();
        }

    }

}
