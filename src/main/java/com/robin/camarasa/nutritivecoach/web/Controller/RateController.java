package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.Rating.Rate;
import com.robin.camarasa.nutritivecoach.Rating.RatingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/rates")
@Transactional
public class RateController {

    private final RatingManager ratingManager;


    @Autowired
    public RateController(RatingManager ratingManager) {
        this.ratingManager = ratingManager;
    }


    @GetMapping(value = "/all")
    public Rate getallfood() {
        return ratingManager.applyRules();
    }


}
