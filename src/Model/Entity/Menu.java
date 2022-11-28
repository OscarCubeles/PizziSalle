package Model.Entity;

import java.util.LinkedList;

public class Menu {
    LinkedList<Pizza> pizzas;
    LinkedList<String> crust;
    LinkedList<Drink> beverages;

    LinkedList<String> ingredients;

    public LinkedList<Pizza> getPizzas() {
        return pizzas;
    }

    public LinkedList<String> getCrust() {
        return crust;
    }

    public LinkedList<Drink> getBeverages() {
        return beverages;
    }

    public LinkedList<String> getIngredients(){
        return ingredients;
    }
}
