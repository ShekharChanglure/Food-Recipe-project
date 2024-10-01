package com.xworkz.foodapp.controller;

import com.xworkz.foodapp.dto.UserDTO;
import com.xworkz.foodapp.service.FoodRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/rest/")
public class FoodRecipeRestController {

    @Autowired
    private FoodRecipeService foodRecipeService;

    public FoodRecipeRestController(){
        System.out.println("Rest Controller Object Created");
    }

    @GetMapping("validateEmail/{emailId}")
    String checkEmailId(@PathVariable String emailId) throws UnsupportedEncodingException{
        String decodeEmailId =  java.net.URLDecoder.decode(emailId,"UTF-8");
        decodeEmailId = decodeEmailId.replace("%2E",".");
        System.out.println(decodeEmailId);
        System.out.println("Inside rest validate emailId");
        UserDTO userDTO = foodRecipeService.validateEmailId(decodeEmailId);
        if (userDTO==null){
            System.out.println("email valid");
            return "false";
        }
        System.out.println("email taken");
        return "true";
    }
}
