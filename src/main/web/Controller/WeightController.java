package com.robin.camarasa.nutritvecoach.web.Controller;


import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.dao.WeightDao;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.model.Weight;
import com.robin.camarasa.nutritvecoach.web.dto.UserDto;
import com.robin.camarasa.nutritvecoach.web.dto.WeightDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/weights")
@Transactional
public class WeightController {

    private final WeightDao weightDao;
    private final UserDao userDao;

    public WeightController(WeightDao weightDao, UserDao userDao) {
        this.weightDao = weightDao;
        this.userDao = userDao;
    }


    @PostMapping(value = "/add/{id}/{value}")
    @ResponseStatus(HttpStatus.CREATED)
    public WeightDto addWeight(@PathVariable Long id, @PathVariable Float value) {
        User user = userDao.getOne(id);
        Weight weight = new Weight(user,value);
        weightDao.save(weight);
        return (new WeightDto(weight));
    }

    @GetMapping(value = "/all")
    public List<WeightDto> getallWeights() {
        return weightDao.findAll().stream().map(WeightDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/findlastten/{id}")
    public List<WeightDto> getLastTen(@PathVariable Long id) {

        List<Weight> weights = weightDao.findAll();
        List<Weight> weights2 = new ArrayList<>();
        for (Weight weight : weights) {
            if(id.equals(weight.getUser().getId())) {
                weights2.add(weight);
            }
        }
        for (int i = 0 ; i < weights2.size() ; i++) {
            for (int j = i+1 ; j < weights2.size() ; j++) {
                if(weights2.get(j).getId() < weights2.get(i).getId()) {
                    Weight tmp = weights2.get(j);
                    weights2.set(j, weights2.get(i));
                    weights2.set(i, tmp);
                }
            }
        }
        return weights2.stream().map(WeightDto::new).collect(Collectors.toList());
    }
}