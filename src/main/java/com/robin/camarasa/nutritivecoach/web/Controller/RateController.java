package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.dao.FoodDao;
import com.robin.camarasa.nutritivecoach.model.Food;
import com.robin.camarasa.nutritivecoach.web.dto.FoodDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodcatDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodnameDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rates")
@Transactional
public class RateController {

    private final FoodDao foodDao;

    public RateController(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @GetMapping(value = "/all")
    public String getallfood() {
        return "test";
    }

}
