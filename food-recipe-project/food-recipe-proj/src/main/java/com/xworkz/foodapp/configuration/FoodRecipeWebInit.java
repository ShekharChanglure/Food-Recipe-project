package com.xworkz.foodapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FoodRecipeWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("Invoking get root config classes");
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        System.out.println("Invoking get servlet config classes");
        return new Class[]{FoodRecipeConfiguration.class};
    }

    protected String[] getServletMappings() {
        System.out.println("Invoking get servlet mappings");
        return new String[]{"/"};
    }
}
