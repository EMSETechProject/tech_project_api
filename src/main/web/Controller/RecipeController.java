package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.FoodCookingDao;
import com.robin.camarasa.nutritvecoach.dao.FoodDao;
import com.robin.camarasa.nutritvecoach.dao.RecipeDao;
import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.FoodCooking;
import com.robin.camarasa.nutritvecoach.model.Recipe;
import com.robin.camarasa.nutritvecoach.web.dto.FoodCookingDto;
import com.robin.camarasa.nutritvecoach.web.dto.FoodCookingLightDto;
import com.robin.camarasa.nutritvecoach.web.dto.RecipeDto;
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


    public RecipeController(RecipeDao recipeDao, FoodCookingDao foodCookingDao, FoodDao foodDao, UserDao userDao) {
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.foodDao = foodDao;
        this.userDao = userDao;
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

    @GetMapping(value = "/meal/{id_user}")
    public List<RecipeDto> getmeal(@PathVariable Long id_user) {
        List<Recipe> meal = new ArrayList<>();
        List<Recipe> recipes = recipeDao.findAll();
        Recipe appetizer = new Recipe();
        Recipe main_course = new Recipe();
        Recipe dessert = new Recipe();
        Collections.shuffle(recipes);
        while (appetizer.getId() == null || main_course.getId() == null || dessert.getId() == null) {
            Collections.shuffle(recipes);
            if(recipes.get(0).getType() == 0) {
                appetizer = recipes.get(0);
            } else if(recipes.get(0).getType() == 1) {
                main_course = recipes.get(0);
            } else if (recipes.get(0).getType() == 2) {
                dessert = recipes.get(0);
            } else {
                return meal.stream().map(RecipeDto::new).collect(Collectors.toList());
            }
        }
        meal.add(appetizer);
        meal.add(main_course);
        meal.add(dessert);
        return meal.stream().map(RecipeDto::new).collect(Collectors.toList());
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
