package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.dao.*;
import com.robin.camarasa.nutritivecoach.model.Food;
import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import com.robin.camarasa.nutritivecoach.model.Objectif;
import com.robin.camarasa.nutritivecoach.model.Recipe;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.Meal.MealCSP;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.core.Assignment;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.core.MinConflictsStrategy;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.core.Variable;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.UserCSPDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodCookingDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodCookingLightDto;
import com.robin.camarasa.nutritivecoach.web.dto.RecipeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/recipes")
@Transactional
public class RecipeController {

    private final RecipeDao recipeDao;
    private final FoodCookingDao foodCookingDao;
    private final FoodDao foodDao;
    private final UserDao userDao;
    private final ObjectifDao objectifDao;


    public RecipeController(RecipeDao recipeDao, FoodCookingDao foodCookingDao, FoodDao foodDao, UserDao userDao, ObjectifDao objectifDao) {
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.foodDao = foodDao;
        this.userDao = userDao;
        this.objectifDao = objectifDao;
    }

    @GetMapping(value = "/all")
    public List<RecipeDto> getallrecipes() {
        return recipeDao.findAll().stream().map(RecipeDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/add/{name}/{type}")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDto addRecipe(@PathVariable String name, @PathVariable Long type) {
        Recipe recipe = new Recipe(name,type);
        recipeDao.save(recipe);
        return (new RecipeDto(recipe));

    }

    @PostMapping(value = "/ingredient/add/{id_recipe}/{food}/{quantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodCookingDto addIngredient(@PathVariable Long id_recipe, @PathVariable String food, @PathVariable Float quantity) {
        Food food1 = foodDao.getOne(getIdFood(food));
        Recipe recipe = recipeDao.getOne(id_recipe);
        FoodCooking foodCooking = new FoodCooking(quantity,food1,recipe);
        foodCookingDao.save(foodCooking);
        return (new FoodCookingDto(foodCooking));
    }

    @GetMapping(value = "/meal/{id_user}/{id_objectif}")
    public List<RecipeCSPDto> getmeal(@PathVariable Long id_user, @PathVariable Long id_objectif) {
        List<Recipe> recipes = recipeDao.findAll();
        List<FoodCooking> foodCookings = foodCookingDao.findAll();

        List<RecipeCSPDto> appetizers = new ArrayList<>();
        List<RecipeCSPDto> main_course = new ArrayList<>();
        List<RecipeCSPDto> dessert = new ArrayList<>();
        List<RecipeCSPDto> results = new ArrayList<>();
        for(Recipe recipe : recipes) {
            List<FoodCooking> foodCookings1 = new ArrayList<>();
            List<Food> foods = new ArrayList<>();
            for(FoodCooking foodCooking : foodCookings) {
                if(foodCooking.getRecipe().getId().equals(recipe.getId())) {
                    foodCookings1.add(foodCooking);
                    foods.add(foodDao.getOne(foodCooking.getFood().getId()));
                }
            }
            if (recipe.getType().equals(0l)){
                appetizers.add(new RecipeCSPDto(recipe, foodCookings1, foods));
            }
            if (recipe.getType().equals(1l)){
                main_course.add(new RecipeCSPDto(recipe, foodCookings1, foods));
            }
            if (recipe.getType().equals(2l)){
                dessert.add(new RecipeCSPDto(recipe, foodCookings1, foods));
            }
        }
        MealCSP mealCSP = new MealCSP(appetizers, main_course, dessert, new UserCSPDto(userDao.getOne(id_user),objectifDao.getOne(id_objectif)));
        MinConflictsStrategy minConflictsStrategy = new MinConflictsStrategy(500);
        Assignment assignment = minConflictsStrategy.solve(mealCSP);
        List<Variable> variables = assignment.getVariables();
        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(0)));
        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(1)));
        results.add((RecipeCSPDto) assignment.getAssignment(variables.get(2)));
        return results;
    }

    @GetMapping(value = "/ingredients/{id}")
    public List<FoodCookingLightDto> getIng(@PathVariable Long id) {
        List<FoodCooking> foodCookings = foodCookingDao.findAll();
        return getfoodcooking(id,foodCookings).stream().map(FoodCookingLightDto::new).collect(Collectors.toList());
    }

    public Long getIdFood(String name) {
        List<Food> foods = foodDao.findAll();
        for(int i = 0 ; i < foods.size() ; i++) {
            if (foods.get(i).getIntitule().equalsIgnoreCase(name)) {
                return foods.get(i).getId();
            }
        }
        return new Long(-1);
    }

    public Long getIdRecipe(String name) {
        List<Recipe> recipeDtos = recipeDao.findAll();
        for(int i = 0 ; i < recipeDtos.size() ; i++) {
            if (recipeDtos.get(i).getName().equalsIgnoreCase(name)) {
                return recipeDtos.get(i).getId();
            }
        }
        return new Long(-1);
    }

    public List<FoodCooking> getfoodcooking(Long id, List<FoodCooking> foodCookings) {
        List<FoodCooking> result = new ArrayList<>();
        for (FoodCooking foodCooking : foodCookings) {
            if(foodCooking.getRecipe().getId().equals(id)) {
                result.add(foodCooking);
            }
        }
        return result;
    }

}
