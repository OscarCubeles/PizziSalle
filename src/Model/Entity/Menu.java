package Model.Entity;

import java.util.LinkedList;

public class Menu {
    LinkedList<Pizza> pizzas;
    LinkedList<String> crust;
    LinkedList<Drink> beverages;

    public LinkedList<Pizza> getPizzas() {
        return pizzas;
    }
}
