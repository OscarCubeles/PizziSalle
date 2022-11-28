package Model.Entity;

import Model.Composite.Order;

import java.util.ArrayList;
import java.util.List;
/**
 * PATTERN: Composite
 */
public class Pizza implements Order {
    private String name;
    private List<Ingredient> ingredients;
    private String crustType;

    public Pizza(){
        name = "Margherita";
        crustType = "Original";
        ingredients = new ArrayList<>();
    }
    public Pizza(String name){
        this.name = name;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(){

    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getCrustType() {
        return crustType;
    }

    @Override
    public void print() {
        System.out.println("Pizza name: " + name + "\nIngredients: \n");
        for (Ingredient ingredient:ingredients) {
            System.out.println(ingredient.getName());
        }
    }
}
