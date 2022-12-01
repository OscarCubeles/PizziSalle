package Controller;

import Model.Entity.Drink;
import Model.Entity.Pizza;
import Model.ModelManager;
import View.View;

// TODO: Store the client in the database
// TODO: request the crust type

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
                case 1 -> requestCustomerDetails();
                case 2 -> {
                    exitProgram = true;
                    view.exit();
                }
            }
        }
    }

    public void requestCustomerDetails(){
        model.setCustomerDelegation(generateDelegation());
        view.showClientView();
        model.setCustomerName(view.requestCustomerName());
        model.setCustomerPhone(view.requestCustomerPhone());
        model.setCustomerAddress(view.requestCustomerAddress());
        model.setCustomerIsFirstOrder(view.requestFirstOrder());
        model.storeCustomerDB();
        startOrder();
    }

    private int generateDelegation(){
        int delegation = (int) (Math.random() * 4);
        model.addDelegation(delegation);
        return delegation;
    }

    private void startOrder(){

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
        view.showOrder(model.getCompositeOrder());
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
        model.addToOrder(new Drink(selectedDrink));
    }

    private void getClientDetails(){
        exitCreateOrder = true;
    }


}


