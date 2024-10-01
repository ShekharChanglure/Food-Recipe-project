package com.xworkz.foodapp.repository;

import com.xworkz.foodapp.dto.FoodRecipeDTO;
import com.xworkz.foodapp.dto.UserDTO;

import java.util.List;

public interface FoodRecipeRepository {
    //User Data Operations
    boolean saveUser(UserDTO userDTO);
    boolean login(String emailId,String password);
    List<UserDTO> getAllUser();
    UserDTO getUserById(int userId);
    UserDTO getUserByLoginId(String emailId);
    boolean updateUser(UserDTO userDTO);
    boolean deleteUserById(int userId);
    UserDTO checkEmailId(String emailId);
    UserDTO checkContactNumber(long contactNumber);

    //FoodRecipe Data Operation
    boolean saveFood(FoodRecipeDTO foodRecipeDTO);
    List<FoodRecipeDTO> viewAllRecipe();
    FoodRecipeDTO getFoodById(int foodRecipeId);
    boolean updateFood(FoodRecipeDTO foodRecipeDTO);
    boolean deleteFoodById(int foodRecipeId);
}
