package com.xworkz.foodapp.service.impl;

import com.xworkz.foodapp.dto.FoodRecipeDTO;
import com.xworkz.foodapp.dto.UserDTO;
import com.xworkz.foodapp.mail.Mail;
import com.xworkz.foodapp.repository.FoodRecipeRepository;
import com.xworkz.foodapp.service.FoodRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodRecipeServiceImpl implements FoodRecipeService {

    @Autowired
    public FoodRecipeRepository foodRecipeRepository;

    @Autowired
    public Mail mail;

    @Override
    public boolean validateAndSaveUser(UserDTO userDTO) {
        mail.sendMail(userDTO);
        return foodRecipeRepository.saveUser(userDTO);
    }

    @Override
    public boolean validateAndLogin(String emailId, String password) {
        if (!emailId.isEmpty() && !password.isEmpty()){
            return foodRecipeRepository.login(emailId, password);
        }else {
            return false;
        }
    }

    @Override
    public List<UserDTO> validateAndGetAllUser() {
        List<UserDTO> userDTOS = foodRecipeRepository.getAllUser();
        if (userDTOS!=null){
            return userDTOS;
        }
        return null;
    }

    @Override
    public UserDTO validateAndGetUserById(int userId) {
        if (userId>0){
            UserDTO userDTO = foodRecipeRepository.getUserById(userId);
            if (userDTO!=null){
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public UserDTO validateAndGetUserByLoginId(String emailId) {
        return foodRecipeRepository.getUserByLoginId(emailId);
    }

    @Override
    public boolean validateAndUpdateUser(UserDTO userDTO) {
        if (userDTO!=null){
            if (!userDTO.getFirstName().isEmpty() && !userDTO.getLastName().isEmpty() && !userDTO.getEmailId().isEmpty() &&
                userDTO.getContactNumber()>1000000000 && userDTO.getAlternativeNumber()>1000000000 && !userDTO.getAddress().isEmpty()){
                if (foodRecipeRepository.updateUser(userDTO)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validateAndDeleteUserById(int userId) {
        if (userId>0){
            if (foodRecipeRepository.deleteUserById(userId));
            return true;
        }
        return false;
    }

    @Override
    public UserDTO validateEmailId(String emailId) {
        if (!emailId.isEmpty()){
            return foodRecipeRepository.checkEmailId(emailId);
        }else {
            return null;
        }
    }

    @Override
    public UserDTO validateContactNumber(long contactNumber) {
        if (contactNumber>0){
            return foodRecipeRepository.checkContactNumber(contactNumber);
        }else {
            return null;
        }
    }

    @Override
    public boolean validateAndSaveFood(FoodRecipeDTO foodRecipeDTO) {
        return foodRecipeRepository.saveFood(foodRecipeDTO);
    }

    @Override
    public List<FoodRecipeDTO> validateAndViewAllRecipe() {
        List<FoodRecipeDTO> foodRecipeDTOS = foodRecipeRepository.viewAllRecipe();
        if (foodRecipeDTOS!=null){
            return foodRecipeDTOS;
        }
        return null;
    }

    @Override
    public FoodRecipeDTO validateAndGetFoodById(int foodRecipeId) {
        if (foodRecipeId>0){
            FoodRecipeDTO foodRecipeDTO = foodRecipeRepository.getFoodById(foodRecipeId);
            if (foodRecipeDTO!=null){
                return foodRecipeDTO;
            }
        }
        return null;
    }

    @Override
    public boolean validateAndUpdateFood(FoodRecipeDTO foodRecipeDTO) {
        if (foodRecipeDTO!=null){
            if (!foodRecipeDTO.getFoodRecipeName().isEmpty() && foodRecipeDTO.getNoOfPerson()>1 && !foodRecipeDTO.getIngredient1().isEmpty() &&
                foodRecipeDTO.getQuantity1()>1 && !foodRecipeDTO.getIngredient2().isEmpty() && foodRecipeDTO.getQuantity2()>1 &&
                !foodRecipeDTO.getIngredient3().isEmpty() && foodRecipeDTO.getQuantity3()>1 && !foodRecipeDTO.getIngredient4().isEmpty() &&
                foodRecipeDTO.getQuantity4()>1 && !foodRecipeDTO.getStepsToDo().isEmpty()){
                if (foodRecipeRepository.updateFood(foodRecipeDTO)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validateAndDeleteFoodById(int foodRecipeId) {
        if (foodRecipeId>0){
            if (foodRecipeRepository.deleteFoodById(foodRecipeId)){
                return true;
            }
        }
        return false;
    }
}
