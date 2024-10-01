package com.xworkz.foodapp.repository.impl;

import com.xworkz.foodapp.dto.FoodRecipeDTO;
import com.xworkz.foodapp.dto.UserDTO;
import com.xworkz.foodapp.repository.FoodRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FoodRecipeRepositoryImpl implements FoodRecipeRepository {

    @Autowired
    public EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveUser(UserDTO userDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userDTO);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean login(String emailId, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("findUserByEmailIdAndPassword");
        query.setParameter("emailId",emailId);
        query.setParameter("password",password);
        try {
            query.getSingleResult();
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("findAll");
        return query.getResultList();
    }

    @Override
    public UserDTO getUserById(int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (UserDTO) entityManager.createNamedQuery("findUserById").setParameter("userId",userId).getSingleResult();
    }

    @Override
    public UserDTO getUserByLoginId(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("findUserByLoginId");
        query.setParameter("emailId",emailId);
        return (UserDTO) query.getSingleResult();
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(userDTO);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteUserById(int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDTO userDTO = entityManager.find(UserDTO.class,userId);
        if (userDTO!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(userDTO);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public UserDTO checkEmailId(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("findEmailId").setParameter("emailId",emailId);
        System.out.println("Hi");
        return (UserDTO) query.getSingleResult();
    }

    @Override
    public UserDTO checkContactNumber(long contactNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query =entityManager.createNamedQuery("getContact").setParameter("contactNumber",contactNumber);
        return (UserDTO) query.getSingleResult();
    }

    @Override
    public boolean saveFood(FoodRecipeDTO foodRecipeDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(foodRecipeDTO);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<FoodRecipeDTO> viewAllRecipe() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("viewAll");
        return query.getResultList();
    }

    @Override
    public FoodRecipeDTO getFoodById(int foodRecipeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (FoodRecipeDTO) entityManager.createNamedQuery("findFoodById").setParameter("foodRecipeId",foodRecipeId).getSingleResult();
    }

    @Override
    public boolean updateFood(FoodRecipeDTO foodRecipeDTO) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(foodRecipeDTO);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteFoodById(int foodRecipeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        FoodRecipeDTO foodRecipeDTO = entityManager.find(FoodRecipeDTO.class,foodRecipeId);
        if (foodRecipeDTO!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(foodRecipeDTO);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
}
