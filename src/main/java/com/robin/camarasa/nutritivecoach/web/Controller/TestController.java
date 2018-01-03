package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.dao.FoodCookingDao;
import com.robin.camarasa.nutritivecoach.dao.FoodDao;
import com.robin.camarasa.nutritivecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritivecoach.dao.RecipeDao;
import com.robin.camarasa.nutritivecoach.model.Food;
import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import com.robin.camarasa.nutritivecoach.model.PhysicalData;
import com.robin.camarasa.nutritivecoach.model.Recipe;
import com.robin.camarasa.nutritivecoach.web.dto.PhysicalDataDto;
import com.robin.camarasa.nutritivecoach.web.dto.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tests")
@Transactional
public class TestController {

    private final RecipeDao recipeDao;
    private final FoodCookingDao foodCookingDao;
    private final FoodDao foodDao;

    public TestController(RecipeDao recipeDao, FoodCookingDao foodCookingDao, FoodDao foodDao) {
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.foodDao = foodDao;
    }

    @GetMapping(value = "/values")
    public List<TestDto> get(@PathVariable Long physicalDataId) {
        List<Recipe> recipes = recipeDao.findAll();
        List<FoodCooking> foodCookings = foodCookingDao.findAll();
        List<TestDto> testDtos = new ArrayList<>();
        for(Recipe recipe : recipes) {
            List<FoodCooking> foodCookings1 = new ArrayList<>();
            for (FoodCooking foodCooking : foodCookings) {
                if(foodCooking.getRecipe().getId().equals(recipe.getId())) {
                    foodCookings1.add(foodCooking);
                }
            }
            testDtos.add(new TestDto(recipe, foodCookings1));
        }
        return testDtos;
    }
}
