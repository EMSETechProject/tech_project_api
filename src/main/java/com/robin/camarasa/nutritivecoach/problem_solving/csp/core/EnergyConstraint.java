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
public class EnergyConstraint implements Constraint {

    private Variable recipe;
    private UserCSPDto userCSPDto;
    private List<Variable> scope;

    public EnergyConstraint(Variable recipe, UserCSPDto userCSPDto) {
        this.recipe = recipe;
        this.userCSPDto = userCSPDto;
        scope = new ArrayList<>(1);
        scope.add(recipe);
    }

    @Override
    public List<Variable> getScope() {
        return scope;
    }

    @Override
    public boolean isSatisfiedWith(Assignment assignment) {
        RecipeCSPDto recipe_CSP_value = (RecipeCSPDto) assignment.getAssignment(recipe);
        if(recipe != null) {
            Float user_cal = userCSPDto.getCalories()/3;
            Float delta_need = Math.abs(recipe_CSP_value.getCalories() - user_cal) / user_cal;
            return (delta_need < 2);
        } return false;
    }
}
