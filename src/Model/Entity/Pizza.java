package Model.Entity;

import Model.Composite.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * PATTERN: Composite
 */
public class Pizza implements Order {
    private final String name;
    private final LinkedList<Ingredient> ingredients;
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
        System.out.print("Pizza name: " + name + "\nIngredients: \n");
        for (int j = 0; j < ingredients.size(); j++) {
            Ingredient ingredient = ingredients.get(j);
            System.out.print(ingredient.getName() + " x" + ingredient.getAmount());
            if(j + 1 < ingredients.size()){
                System.out.print(", ");
            }
        }
        System.out.println("\n");
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
