package com.example.simple_template.api;

import com.example.simple_template.dto.FoodDto;
import com.example.simple_template.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {
    private final FoodService foodService;


    @GetMapping
    public List<FoodDto> getAllUsers() {
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public FoodDto getUserById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @PostMapping
    public Long saveUser(@RequestBody FoodDto food) {
        return foodService.saveFood(food);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}