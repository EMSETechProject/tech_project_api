package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.dao.*;
import com.robin.camarasa.nutritivecoach.model.*;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.Meal.MealCSP;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.core.*;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.UserCSPDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tests")
@Transactional
public class TestController {

    private final RecipeDao recipeDao;
    private final FoodCookingDao foodCookingDao;
    private final FoodDao foodDao;
    private final UserDao userDao;
    private final ObjectifDao objectifDao;

    public TestController(RecipeDao recipeDao, FoodCookingDao foodCookingDao, FoodDao foodDao, UserDao userDao, ObjectifDao objectifDao) {
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.foodDao = foodDao;
        this.userDao = userDao;
        this.objectifDao = objectifDao;
    }

    @GetMapping(value = "/a")
    public String tes() {
        return "a";
    }

    @GetMapping(value = "/values")
    public List<RecipeCSPDto> get() {
        List<Recipe> recipes = recipeDao.findAll();
        List<FoodCooking> foodCookings = foodCookingDao.findAll();
        List<RecipeCSPDto> recipeCSPDtos = new ArrayList<>();
        for(Recipe recipe : recipes) {
            List<FoodCooking> foodCookings1 = new ArrayList<>();
            List<Food> foods = new ArrayList<>();
            for(FoodCooking foodCooking : foodCookings) {
                if(foodCooking.getRecipe().getId().equals(recipe.getId())) {
                    foodCookings1.add(foodCooking);
                    foods.add(foodDao.getOne(foodCooking.getFood().getId()));
                }
            }
            recipeCSPDtos.add(new RecipeCSPDto(recipe, foodCookings1, foods));
        }
        return recipeCSPDtos;
    }

    @GetMapping(value = "/test")
    public List<RecipeCSPDto> getMeal() {
        return get();
    }

//    @GetMapping(value = "/test2")
//    public List<RecipeCSPDto> getMeal2() {
//
//        List<Recipe> recipes = recipeDao.findAll();
//        List<FoodCooking> foodCookings = foodCookingDao.findAll();
//
//        List<RecipeCSPDto> appetizers = new ArrayList<>();
//        List<RecipeCSPDto> main_course = new ArrayList<>();
//        List<RecipeCSPDto> dessert = new ArrayList<>();
//        List<RecipeCSPDto> results = new ArrayList<>();
//        for(Recipe recipe : recipes) {
//            List<FoodCooking> foodCookings1 = new ArrayList<>();
//            List<Food> foods = new ArrayList<>();
//            for(FoodCooking foodCooking : foodCookings) {
//                if(foodCooking.getRecipe().getId().equals(recipe.getId())) {
//                    foodCookings1.add(foodCooking);
//                    foods.add(foodDao.getOne(foodCooking.getFood().getId()));
//                }
//            }
//            if (recipe.getType().equals(0l)){
//                appetizers.add(new RecipeCSPDto(recipe, foodCookings1, foods));
//            }
//            if (recipe.getType().equals(1l)){
//                main_course.add(new RecipeCSPDto(recipe, foodCookings1, foods));
//            }
//            if (recipe.getType().equals(2l)){
//                dessert.add(new RecipeCSPDto(recipe, foodCookings1, foods));
//            }
//        }
//
//        MealCSP mealCSP = new MealCSP(appetizers, main_course, dessert, testUser());
//        MinConflictsStrategy minConflictsStrategy = new MinConflictsStrategy(500);
//        Assignment assignment = minConflictsStrategy.solve(mealCSP);
//        List<Variable> variables = assignment.getVariables();
//        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(0)));
//        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(1)));
//        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(2)));
//        return results;
//    }

    @GetMapping(value = "/test3")
    public UserCSPDto testUser() {
        return new UserCSPDto(userDao.getOne(411l), objectifDao.getOne(91l));
    }
}