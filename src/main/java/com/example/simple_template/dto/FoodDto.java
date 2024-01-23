package com.example.simple_template.dto;

public class FoodDto {
    private Long id;
    private String name;
    private Long calories;

    public FoodDto(Long id, String name, Long calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }
}
