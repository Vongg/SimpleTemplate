package com.example.simple_template.service;


import com.example.simple_template.dto.FoodDto;
import com.example.simple_template.exception.NoSuchFoodException;
import com.example.simple_template.model.Food;
import com.example.simple_template.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodDto> getAllFoods() {
        List<Food> foodList = foodRepository.findAll();
        List<FoodDto> foodDtoList = new ArrayList<>();

        for (Food food : foodList) {
            FoodDto foodDto = new FoodDto(food.getId(), food.getName(), food.getCalories());
            foodDtoList.add(foodDto);
        }

        return foodDtoList;
    }

    public FoodDto getFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new NoSuchFoodException("No such food with id " + id));
        return new FoodDto(food.getId(), food.getName(), food.getCalories());
    }

    public Long saveFood(FoodDto food) {
        Food saved = foodRepository.save(new Food(food.getName(), food.getCalories()));
        return saved.getId();
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
