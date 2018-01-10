package com.robin.camarasa.nutritivecoach.web.Controller;


import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNNetwork;
import com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.dao.*;
import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import com.robin.camarasa.nutritivecoach.model.Preferences;
import com.robin.camarasa.nutritivecoach.model.Recipe;
import com.robin.camarasa.nutritivecoach.model.User;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/preferences")
@Transactional
public class PreferencesController {

    private final PreferencesDao preferencesDao;
    private final UserDao userDao;
    private final RecipeDao recipeDao;
    private final FoodCookingDao foodCookingDao;
    private final NNNetworkDao nnNetworkDao;

    public PreferencesController(PreferencesDao preferencesDao, UserDao userDao, RecipeDao recipeDao, FoodCookingDao foodCookingDao, NNNetworkDao nnNetworkDao) {
        this.preferencesDao = preferencesDao;
        this.userDao = userDao;
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.nnNetworkDao = nnNetworkDao;
    }

    @GetMapping(value = "/set/{id_user}/{id_recipe}/{value}")
    public String learn(@PathVariable Long id_user, @PathVariable Long id_recipe, @PathVariable Float value) {
        User user = userDao.getOne(id_user);
        Recipe recipe = recipeDao.getOne(id_recipe);
        List<FoodCooking> foodCookings = foodCookingDao.findAll();
        for (FoodCooking foodCooking : foodCookingDao.findAll()) {
            if(foodCooking.getRecipe().getId().equals(id_recipe)) {
                foodCookings.add(foodCooking);
            }
        }
        RecipeCSPDto recipeCSPDto = new RecipeCSPDto(recipe, foodCookings);
        for (Preferences preferences : preferencesDao.findAll()) {
            if (preferences.getUser().getId().equals(id_user) && preferences.getRecipe().getId().equals(id_recipe)) {
                preferences.setValue(value);
            }
        }
        NNNetwork nnNetwork = nnNetworkDao.getOne(1l);
        nnNetwork.learn(user,recipeCSPDto,value);
        return "Success";
    }
}