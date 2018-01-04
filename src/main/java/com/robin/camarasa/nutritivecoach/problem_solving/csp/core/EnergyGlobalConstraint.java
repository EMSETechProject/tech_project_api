package com.robin.camarasa.nutritivecoach.problem_solving.csp.core;



import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.RecipeCSPDto;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.UserCSPDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a binary constraint which forbids equal values.
 *
 * @author Ruediger Lunde
 */
public class EnergyGlobalConstraint implements Constraint {

    private Variable appetizer;
    private Variable main_course;
    private Variable dessert;
    private UserCSPDto userCSPDto;
    private List<Variable> scope;

    public EnergyGlobalConstraint(Variable appetizer, Variable main_course, Variable dessert, UserCSPDto userCSPDto) {
        this.appetizer = appetizer;
        this.main_course = main_course;
        this.dessert = dessert;
        this.userCSPDto = userCSPDto;
        scope = new ArrayList<>();
        scope.add(appetizer);
        scope.add(main_course);
        scope.add(dessert);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        RecipeCSPDto app_value = (RecipeCSPDto) assignment.getAssignment(appetizer);
        RecipeCSPDto main_value = (RecipeCSPDto) assignment.getAssignment(main_course);
        RecipeCSPDto dessert_value = (RecipeCSPDto) assignment.getAssignment(dessert);
        if(app_value != null && main_value != null && dessert_value != null) {
            Float user_cal = userCSPDto.getCalories();
            Float delta_need = Math.abs(app_value.getCalories() + main_value.getCalories() + dessert_value.getCalories() - user_cal) / user_cal;
            return (delta_need < 0.2);
        } return false;
    }
}
