package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.FoodDao;
import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.web.dto.FoodDto;
import com.robin.camarasa.nutritvecoach.web.dto.FoodcatDto;
import com.robin.camarasa.nutritvecoach.web.dto.FoodnameDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/foods")
@Transactional
public class FoodController {

    private final FoodDao foodDao;

    public FoodController(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @GetMapping(value = "/all")
    public List<FoodDto> getallfood() {
        return foodDao.findAll().stream().map(FoodDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/findbyname/{name}")
    public FoodDto getfood(@PathVariable String name) {
        List<Food> foods = foodDao.findAll();
        for (Food food : foods) {
            if(food.getIntitule().equalsIgnoreCase(name)) {
                return (new FoodDto(food));
            }
        }
        return (new FoodDto(new Food()));
    }

    @GetMapping(value = "/cat")
    public List<FoodcatDto> getfoodcat() {
        List<FoodcatDto> allcat = foodDao.findAll().stream().map(FoodcatDto::new).collect(Collectors.toList());
        return deleteDoubles(allcat);
    }

    @GetMapping(value = "/cat/{cat}")
    public List<FoodnameDto> getfoodfromcat(@PathVariable String cat) {
        return selectfoodcat(cat,foodDao.findAll());
    }

    @GetMapping(value = "/catfulldata/{cat}")
    public List<FoodDto> getfooddatafromcat(@PathVariable String cat) {
        return selectfoodcatfulldata(cat,foodDao.findAll());
    }


    public List<FoodnameDto> selectfoodcat(String foodcatDto, List<Food> foods) {
        List<FoodnameDto> res = new ArrayList<>();
        for (int i = 0 ; i < foods.size() ; i++) {
            if(foods.get(i).getCategorie().equalsIgnoreCase(foodcatDto)) {
                res.add(new FoodnameDto(foods.get(i)));
            }
        }
        return res;
    }

    public List<FoodDto> selectfoodcatfulldata(String foodcatDto, List<Food> foods) {
        List<FoodDto> res = new ArrayList<>();
        for (int i = 0 ; i < foods.size() ; i++) {
            if(foods.get(i).getCategorie().equalsIgnoreCase(foodcatDto)) {
                res.add(new FoodDto(foods.get(i)));
            }
        }
        return res;
    }

    public List<FoodcatDto> deleteDoubles(List<FoodcatDto> foodcatDtos) {
        List<FoodcatDto> res = new ArrayList<>();
        res.add(foodcatDtos.get(0));
        FoodcatDto foodcatDto = foodcatDtos.get(0);
        for(int i = 0 ; i < foodcatDtos.size() ; i++) {
            if(foodcatDtos.get(i).getCat().equalsIgnoreCase(foodcatDto.getCat())) {

            } else {
                foodcatDto = foodcatDtos.get(i);
                res.add(foodcatDtos.get(i));
            }
        }
        return res;
    }


}
