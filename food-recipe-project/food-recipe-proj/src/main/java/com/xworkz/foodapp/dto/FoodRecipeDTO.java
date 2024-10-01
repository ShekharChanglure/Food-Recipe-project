package com.xworkz.foodapp.dto;

import com.xworkz.foodapp.constant.Cuisine;
import com.xworkz.foodapp.constant.FoodType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FoodRecipeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int foodRecipeId;
    String foodRecipeName;
    int noOfPerson;
    String ingredient1;
    int quantity1;
    String ingredient2;
    int quantity2;
    String ingredient3;
    int quantity3;
    String ingredient4;
    int quantity4;
    String stepsToDo;
    @Enumerated(EnumType.STRING)
    FoodType foodType;
    @Enumerated(EnumType.STRING)
    Cuisine cuisine;
    private int userId;
}
