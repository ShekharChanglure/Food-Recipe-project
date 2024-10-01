package com.xworkz.foodapp.controller;


import com.xworkz.foodapp.dto.FoodRecipeDTO;
import com.xworkz.foodapp.dto.UserDTO;
import com.xworkz.foodapp.service.FoodRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FoodRecipeController {

    @Autowired
    public FoodRecipeService foodRecipeService;

    @PostMapping("register")
    String save(@ModelAttribute UserDTO userDTO, Model model){
        if (userDTO!=null){
            System.out.println(userDTO);
            foodRecipeService.validateAndSaveUser(userDTO);
            model.addAttribute("user",userDTO.getFirstName());
            return "register";
        }
        return "error";
    }

    @PostMapping("")
    String login(@RequestParam String emailId, @RequestParam String password, Model model){
        if (foodRecipeService.validateAndLogin(emailId, password)){
            UserDTO userDTO = foodRecipeService.validateAndGetUserByLoginId(emailId);
            model.addAttribute("login","Welcome"+userDTO.getFirstName());
            model.addAttribute("food",userDTO.getUserId());
            return "";
        }
        model.addAttribute("login","Invalid Login not Registered");
        return "";
    }

    @GetMapping("")
    String getAllUsers(Model model){
        List userList = foodRecipeService.validateAndGetAllUser();
        if (userList!=null){
            model.addAttribute("userList",userList);
            return "";
        }
        return "";
    }

    @GetMapping("")
    String getUserById(@RequestParam int userId, Model model){
        UserDTO userDTO = foodRecipeService.validateAndGetUserById(userId);
        if (userDTO!=null){
            model.addAttribute("food",userDTO);
            return "";
        }
        return "";
    }

    @PostMapping("")
    String updateUser(@ModelAttribute UserDTO userDTO, Model model){
        if (userDTO!=null){
            foodRecipeService.validateAndUpdateUser(userDTO);
            model.addAttribute("updateMessage","food:"+userDTO.getFirstName()+"updated!!!");
            model.addAttribute("login","Welcome"+userDTO.getFirstName());
            return "";
        }
        return "";
    }

    @GetMapping("")
    String deleteUserById(@RequestParam int userId, Model model){
        if (foodRecipeService.validateAndDeleteUserById(userId)){
            model.addAttribute("deleted",userId);
            return "";
        }
        return "";
    }

    @PostMapping("")
    String saveFood(@ModelAttribute FoodRecipeDTO foodRecipeDTO, Model model){
        if (foodRecipeDTO!=null){
            foodRecipeService.validateAndSaveFood(foodRecipeDTO);
            model.addAttribute("recipe",foodRecipeDTO.getFoodRecipeName());
            return "";
        }
        return "";
    }

    @GetMapping("")
    String getAddRecipePage(@RequestParam int userId, Model model){
        model.addAttribute("userId",userId);
        return "";
    }

    @GetMapping("")
    String viewAll(Model model){
        List listFood = foodRecipeService.validateAndGetAllUser();
        if (listFood!=null){
            model.addAttribute("listFood",listFood);
            return "";
        }
        return "";
    }

    @GetMapping("")
    String viewUserById(@RequestParam int userId, Model model){
        model.addAttribute("userId",userId);
        return "";
    }

    @GetMapping("")
    String getFoodById(@RequestParam int foodRecipeId, Model model){
        FoodRecipeDTO foodRecipeDTO = foodRecipeService.validateAndGetFoodById(foodRecipeId);
        if (foodRecipeDTO!=null){
            model.addAttribute("recipe",foodRecipeDTO);
            return "";
        }
        return "";
    }

    @PostMapping("")
    String updateFood(@ModelAttribute FoodRecipeDTO foodRecipeDTO, Model model){
        if (foodRecipeDTO!=null){
            foodRecipeService.validateAndUpdateFood(foodRecipeDTO);
            model.addAttribute("updateMessage","recipe:"+foodRecipeDTO.getFoodRecipeName()+"updated");
            return viewAll(model);
        }
        return "";
    }

    @GetMapping("")
    String deleteFoodById(@RequestParam int foodRecipeId, Model model){
        if (foodRecipeService.validateAndDeleteFoodById(foodRecipeId)){
            model.addAttribute("remove",foodRecipeId);
            return viewAll(model);
        }
        return "";
    }
}
