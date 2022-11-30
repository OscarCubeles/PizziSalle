package Model.Entity;

import Model.Composite.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * PATTERN: Composite
 */
public class Pizza implements Order {
    private String name;
    private LinkedList<Ingredient> ingredients;
    private String crustType;

    public Pizza(){
        name = "Margherita";
        crustType = "Original";
        ingredients = new LinkedList<>();
    }
    public Pizza(String name){
        this.name = name;
        ingredients = new LinkedList<>();
    }

    public void addIngredient(String ingredientName){
        boolean exists = false;
        for (Ingredient ingredient: this.ingredients) {
            if(ingredient.getName().compareTo(ingredientName) == 0){
                ingredient.increaseAmount();
                exists = true;
            }
        }
        if(!exists){
            this.ingredients.add(new Ingredient(ingredientName));
        }
    }


    public String getName() {
        return name;
    }

    public LinkedList<Ingredient> getIngredients() {
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

    public void removeIngredient(String ingredientName){
        for (Ingredient ingredient: ingredients) {
            if(ingredient.getName().compareTo(ingredientName) == 0){
                if(ingredient.getAmount() > 1){
                    ingredient.decreaseAmount();
                }else{
                    ingredients.remove(ingredient);
                }
            }
        }
    }
}
