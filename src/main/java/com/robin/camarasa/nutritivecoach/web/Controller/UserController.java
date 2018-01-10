package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNNetwork;
import com.robin.camarasa.nutritivecoach.dao.*;
import com.robin.camarasa.nutritivecoach.model.*;
import com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.web.dto.ObjectifDto;
import com.robin.camarasa.nutritivecoach.web.dto.UserConnectionDto;
import com.robin.camarasa.nutritivecoach.web.dto.UserDto;
import com.robin.camarasa.nutritivecoach.web.dto.UserFullDataDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
@Transactional
public class UserController {

    private final UserDao userDao;
    private final ObjectifDao objectifDao;
    private final PhysicalDataDao physicalDataDao;
    private final PreferencesDao preferencesDao;
    private final FoodCookingDao foodCookingDao;
    private final RecipeDao recipeDao;
    private final NNNetworkDao nnNetworkDao;


    public UserController(UserDao userDao, ObjectifDao objectifDao, PhysicalDataDao physicalDataDao, PreferencesDao preferencesDao, FoodCookingDao foodCookingDao, RecipeDao recipeDao, NNNetworkDao nnNetworkDao) {
        this.userDao = userDao;
        this.objectifDao = objectifDao;
        this.physicalDataDao = physicalDataDao;
        this.preferencesDao = preferencesDao;
        this.foodCookingDao = foodCookingDao;
        this.recipeDao = recipeDao;
        this.nnNetworkDao = nnNetworkDao;
    }

    @GetMapping(value = "/findbyid/{userId}")
    public UserDto get(@PathVariable Long userId) {
        return (new UserDto(userDao.getOne(userId)));
    }

    @GetMapping(value = "/all")
    public List<UserDto> getall() {
        return userDao.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/findbypp/{pseudo}/{password}")
    public UserConnectionDto checkconnection(@PathVariable String pseudo, @PathVariable String password) {
        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getPassword().equalsIgnoreCase(password) && users.get(i).getPseudo().equalsIgnoreCase(pseudo)) {
                return (new UserConnectionDto(users.get(i).getId()));
            }
        }
        return (new UserConnectionDto(-1l));
    }

    @PostMapping(value = "/add/{pseudo}/{password}/{id}")
    public UserConnectionDto add(@PathVariable String pseudo, @PathVariable String password, @PathVariable Long id) {
        try {
            PhysicalData physicalData = physicalDataDao.getOne(id);
            User user = new User(pseudo,password,physicalData);
            userDao.save(user);
            List<Recipe> recipes = recipeDao.findAll();
            NNNetwork nnNetwork = nnNetworkDao.getOne(1l);
            for (Recipe recipe : recipes) {

                List<FoodCooking> foodCookings = foodCookingDao.findAll();
                List<FoodCooking> foodCookings1 = new ArrayList<>();
                List<Food> foods = new ArrayList<>();
                for (FoodCooking foodCooking : foodCookings) {
                    if(recipe.getId().equals(foodCooking.getRecipe().getId())) {
                        foodCookings1.add(foodCooking);
                    }
                }
                RecipeCSPDto recipeCSPDto = new RecipeCSPDto(recipe, foodCookings1);
                Float value = nnNetwork.computePreference(user, recipeCSPDto);
                Preferences preferences = new Preferences(value, user, recipe);
            }
            return (new UserConnectionDto(user));
        }catch (Exception e) {
            return (new UserConnectionDto(-1L));
        }

    }

    @GetMapping(value = "/findbyp/{pseudo}")
    public UserConnectionDto findbyp(@PathVariable String pseudo) {
        List<User> users = userDao.findAll();
        for (User user : users) {
            if (user.getPseudo().equalsIgnoreCase(pseudo)) {
                return new UserConnectionDto(user);
            }
        }
        return new UserConnectionDto(-1L);
    }

    @GetMapping(value = "/loaddata/{pseudo}/{password}")
    public UserFullDataDto getdata(@PathVariable String pseudo, @PathVariable String password) {
        ObjectifController objectifController = new ObjectifController(objectifDao,userDao);
        UserConnectionDto userConnectionDto;
        try {
            userConnectionDto = this.checkconnection(pseudo,password);
            UserDto userDto = this.get(userConnectionDto.getId());
            User user = new User(userDto.getId(), pseudo,password,userDto.getPhysicalData());
            ObjectifDto objectifDto = objectifController.getobjectifsbyid(user.getId());
            Objectif objectif = new Objectif(objectifDto.getId(),user,objectifDto.getValue());
            return (new UserFullDataDto(user,objectif));
        } catch (Exception e) {
            return (new UserFullDataDto(
                        new User(
                                -1L,
                                "err",
                                "err",
                                new PhysicalData(
                                        -1L,
                                        -1,
                                        -1F,
                                        -1F)),
                        new Objectif(-1L,
                                    new User(
                                            -1L,
                                            "err",
                                            "err",
                                            new PhysicalData(-1L,
                                                    -1,
                                                    -1F,
                                                    -1F)),
                                    -1F)));
        }
    }

    @PostMapping(value = "/modify/{id}/{password}")
    public UserDto change(@PathVariable Long id, @PathVariable String password) {
        User user = userDao.getOne(id);
        user.setPassword(password);
        userDao.save(user);
        return (new UserDto(user));
    }
}