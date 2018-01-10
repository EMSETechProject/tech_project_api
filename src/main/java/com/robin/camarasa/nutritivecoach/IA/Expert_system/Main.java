package com.robin.camarasa.nutritivecoach.IA.Expert_system;


import com.robin.camarasa.nutritivecoach.model.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rate");
        Preferences preferences1 =
                new Preferences(
                        0.51f,
                        new User(
                                "test",
                                "test",
                                new PhysicalData(
                                        1,
                                        0.5f,
                                        0.5f
                                )
                        ),
                        new Recipe(
                                "test",
                                2l,
                                1l
                        )
                );

        Preferences preferences2 =
                new Preferences(
                        0.2f,
                        new User(
                                "test",
                                "test",
                                new PhysicalData(
                                        1,
                                        0.5f,
                                        0.5f
                                        )
                        ),
                        new Recipe(
                                "test",
                                2l,
                                2l
                        )
                );

        Recipe recipe = new Recipe("test", 2l, 1l);
        Recipe recipe2 = new Recipe("test", 2l, 2l);

        kSession.insert(preferences1);
        kSession.insert(preferences2);
        kSession.insert(recipe);
        kSession.insert(recipe2);
        kSession.fireAllRules();
        for (Object object : kSession.getObjects()) {
            if (object.getClass().equals(Recipe.class)) {
                System.out.println(((Preferences) object).toString() + "\n");
            }
            if (object.getClass().equals(preferences1)) {

            }
        }
    }
}
