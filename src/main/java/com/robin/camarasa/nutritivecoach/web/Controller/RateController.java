package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.dao.FoodDao;
import com.robin.camarasa.nutritivecoach.model.*;
import com.robin.camarasa.nutritivecoach.web.dto.FoodDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodcatDto;
import com.robin.camarasa.nutritivecoach.web.dto.FoodnameDto;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
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

    private KieServices ks = KieServices.Factory.get();
    private KieContainer kContainer = ks.getKieClasspathContainer();
    private KieSession kSession = kContainer.newKieSession("ksession-rate");


    public RateController() {

    }

    @GetMapping(value = "/all")
    public String getallfood() {
        Preferences preferences = new Preferences(2.5f,
                                                    new User( "pseudo",
                                                            "password",
                                                            new PhysicalData(21,
                                                                    0.5f,
                                                                    0.5f)
                                                    ),new Recipe(
                                                            "test",
                                                            2l));
        kSession.insert(preferences);
        kSession.fireAllRules();
        return "tests";
    }

}
