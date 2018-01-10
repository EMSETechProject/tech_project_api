package com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.Meal;


import com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.core.*;
import com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.IA.problem_solving.csp.db.UserCSPDto;

import java.util.List;

/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.1, Page 204.<br>
 * <br>
 * The principal states and territories of Australia. Coloring this map can be
 * viewed as a constraint satisfaction problem (CSP). The goal is to assign
 * colors to each region so that no neighboring regions have the same color.
 *
 * @author Ruediger Lunde
 * @author Mike Stampone
 */
public class MealCSP extends CSP {
    public static final Variable entrance = new Variable("entrance");
    public static final Variable main_course = new Variable("main_course");
    public static final Variable dessert = new Variable("dessert");

    public MealCSP(List<RecipeCSPDto> entrances, List<RecipeCSPDto> main_courses, List<RecipeCSPDto> desserts, UserCSPDto userCSPDto) {
        collectVariables();
        Object[] entrances_obj = new Object[entrances.size()];
        Object[] main_courses_obj = new Object[main_courses.size()];
        Object[] desserts_obj = new Object[desserts.size()];

        for(int i = 0 ; i < entrances.size() ; i++)
            entrances_obj[i] = entrances.get(i);

        for(int i = 0 ; i < main_courses.size() ; i++)
            main_courses_obj[i] = main_courses.get(i);

        for(int i = 0 ; i < desserts.size() ; i++)
            desserts_obj[i] = desserts.get(i);

        setDomain(entrance, new Domain(entrances_obj));
        setDomain(main_course, new Domain(main_courses_obj));
        setDomain(dessert, new Domain(desserts_obj));

        addConstraint(new EnergyConstraint(entrance, userCSPDto));
        addConstraint(new EnergyConstraint(main_course, userCSPDto));
        addConstraint(new EnergyConstraint(dessert, userCSPDto));
        addConstraint(new EnergyGlobalConstraint(entrance, main_course, dessert, userCSPDto));
    }


    private void collectVariables() {
        addVariable(entrance);
        addVariable(main_course);
        addVariable(dessert);
    }
}