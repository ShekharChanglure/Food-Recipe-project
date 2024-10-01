package com.xworkz.foodapp.service;

import com.xworkz.foodapp.dto.FoodRecipeDTO;
import com.xworkz.foodapp.dto.UserDTO;

import java.util.List;

public interface FoodRecipeService {
    //User Data Operations
    boolean validateAndSaveUser(UserDTO userDTO);
    boolean validateAndLogin(String emailId,String password);
    List<UserDTO> validateAndGetAllUser();
    UserDTO validateAndGetUserById(int userId);
    UserDTO validateAndGetUserByLoginId(String emailId);
    boolean validateAndUpdateUser(UserDTO userDTO);
    boolean validateAndDeleteUserById(int userId);
    UserDTO validateEmailId(String emailId);
    UserDTO validateContactNumber(long contactNumber);

    //FoodRecipe Data Operation
    boolean validateAndSaveFood(FoodRecipeDTO foodRecipeDTO);
    List<FoodRecipeDTO> validateAndViewAllRecipe();
    FoodRecipeDTO validateAndGetFoodById(int foodRecipeId);
    boolean validateAndUpdateFood(FoodRecipeDTO foodRecipeDTO);
    boolean validateAndDeleteFoodById(int foodRecipeId);
}
