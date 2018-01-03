package com.robin.camarasa.nutritivecoach.Rating;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingManager {

    private final KieContainer kieContainer;

    @Autowired
    public RatingManager(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    public Rate applyRules() {
        KieSession kieSession = kieContainer.newKieSession();
        Rate rate = new Rate(9f);
        kieSession.insert(rate);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rate;
    }

}
