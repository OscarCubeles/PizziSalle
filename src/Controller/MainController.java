package Controller;

import Model.Entity.Pizza;
import Model.ModelManager;
import View.View;

public class MainController {
    private boolean exitProgram = false;
    boolean exitCreateOrder = false;

    boolean exitEditPizza = false;
    private final View view;
    private final ModelManager model;
    public MainController(View view, ModelManager model) {
        this.view = view;
        this.model = model;
    }

    public void start(){
        while(!exitProgram){
            switch (view.initialView()) {
                case 1 -> startOrder();
                case 2 -> {
                    exitProgram = true;
                    view.exit();
                }
            }
        }
    }

    private void startOrder(){
        // TODO: Generate a random delegation and add the pizza to its iterator :S
        while(!exitCreateOrder){
            switch (view.newOrder()) {
                case 1 -> addPizza();
                case 2 -> addDrink();
                case 3 -> viewOrder();
                case 4 -> getClientDetails();
                case 5 -> exitProgram = true;
            }
        }
    }

    private void viewOrder(){

    }

    private void selectDelegation(){

    }

    private void addPizza(){
        int pizzaIndex = view.showPizzas(model.getPizzaIterator());

        Pizza selectedPizza = model.getPizza(pizzaIndex);
        while(!exitEditPizza){
            switch (view.showSelectedPizza(selectedPizza)) {
                case 1 -> {
                    String newIngredient = view.selectIngredient(model.getIngredients());
                    selectedPizza.addIngredient(newIngredient);
                }
                case 2 -> {
                    // Pass the list of ingredients of the pizza
                    String oldIngredient = view.selectIngredient(selectedPizza.getIngredients());
                    selectedPizza.removeIngredient(oldIngredient);
                }
                case 3 -> {
                    exitEditPizza = true;
                }
            }
        }
        exitEditPizza = false;
        model.addToOrder(selectedPizza);
        System.out.println();
    }



    private void addDrink(){
        String selectedDrink = view.showDrinks(model.getDrinkIterator());


    }

    private void getClientDetails(){
        exitCreateOrder = true;
    }


}


