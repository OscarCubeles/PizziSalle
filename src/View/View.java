package View;

import Model.Composite.CompositeOrder;
import Model.Entity.Customer;
import Model.Entity.Drink;
import Model.Entity.Ingredient;
import Model.Entity.Pizza;
import Model.Iterator.Iterator;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("SpellCheckingInspection")
    public int initialView() {
        String option;
            System.out.println("-----------------------------------------------");
            System.out.println("\tWelcome to PizziSalle");
            System.out.println("-----------------------------------------------");
            System.out.println("\t[1] - Start an order");
            System.out.println("\t[2] - Exit");
        do{
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println();
            if (option.compareTo("1") == 0 || option.compareTo("2") == 0) {
                break;
            }else{
                System.out.println("Invalid input. Enter either 1 or 2.");
            }
        }while(true);
        return Integer.parseInt(option);
    }

    public int newOrder() {
        String option;
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("\tCreate a new order");
            System.out.println("-----------------------------------------------");
            System.out.println("\t[1] - Add Pizza");
            System.out.println("\t[2] - Add Drink");
            System.out.println("\t[3] - View Order");
            System.out.println("\t[4] - Proceed with the checkout");
            System.out.println("\t[5] - Exit");
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println();
        }while(option.compareTo("1") != 0 && option.compareTo("2") != 0
                && option.compareTo("3") != 0 && option.compareTo("4") != 0 && option.compareTo("5") != 0);
        return Integer.parseInt(option);
    }

    public void exit(){
        System.out.println("\nBye!\n");
    }

    public void showPizzaIngredients(Pizza pizza){
        for (int j = 0; j < pizza.getIngredients().size(); j++) {
            Ingredient ingredient = pizza.getIngredients().get(j);
            System.out.print(ingredient.getName() + " x" + ingredient.getAmount());
            if(j + 1 < pizza.getIngredients().size()){
                System.out.print(", ");
            }
        }
    }

    public void showOrder(CompositeOrder order){
        System.out.println("-----------------------------------------------");
        System.out.println("\tYour Order");
        System.out.println("-----------------------------------------------");
        order.print();
        System.out.println();
    }

    public int showPizzas(Iterator iterator){
        String option;
        int i;
        System.out.println("-----------------------------------------------");
        System.out.println("\tSelect a pizza");
        System.out.println("-----------------------------------------------");
        for(i = 1; iterator.hasNext(); i++){
            Pizza pizza = (Pizza) iterator.next();
            System.out.print("\t[" + i + "] - " + pizza.getName() + ": ");
            showPizzaIngredients(pizza);
            System.out.println();
        }

        do{
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println();
            if(!isPizzaValid(i, option)){
                System.out.println("Invalid option. To select a pizza enter the number next to it.");
            }else{
                break;
            }
        }while(true);
        return Integer.parseInt(option);
    }

    public boolean isPizzaValid(int numPizzas, String option){
        try{
            return Integer.parseInt(option) > 0 && Integer.parseInt(option) <= numPizzas;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public String showDrinks(@NotNull Iterator iterator, Customer customer){
        String option;
        LinkedList<Drink> drinksCopy = new LinkedList<>();
        System.out.println("-----------------------------------------------");
        System.out.println("\tSelect a drink");
        System.out.println("-----------------------------------------------");
        for(int i = 1; iterator.hasNext(); i++){
            Drink drink = (Drink)iterator.next();
            drinksCopy.add(new Drink(drink.getName(), drink.getMinAge()));
            System.out.println("\t[" + i + "] - " + drink.getName());
        }
        do{
            System.out.print("Enter the drink name: ");
            option = scanner.nextLine();
            System.out.println();
            if(!isValidDrink(option, drinksCopy)){
                System.out.println("Invalid option. To select a drink enter the number next to it.");
            }else if(isUnderage(customer.getAge(), option, drinksCopy)){
                System.out.println("Invalid option. You must be an adult to get this drink.");
            }else{
                break;
            }
        }while(true);
        return option;
    }

    private boolean isUnderage(int age, String drinkName, @NotNull LinkedList<Drink> drinks){
        for(Drink drink : drinks){
            if(drinkName.compareTo(drink.getName()) == 0 && age > drink.getMinAge()) return false;
        }
        return true;
    }

    private boolean isValidDrink(String drinkName, @NotNull LinkedList<Drink> drinks){
        for(Drink drink : drinks){
            if(drinkName.compareTo(drink.getName()) == 0) return true;
        }
        return false;
    }

    public int showSelectedPizza(@NotNull Pizza pizza){
        String option;
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("\tEdit your Pizza");
            System.out.print("\tYou have selected a " + pizza.getName() + " with: ");
            showPizzaIngredients(pizza);
            System.out.println("\n-----------------------------------------------");
            System.out.println("Would you like to: ");
            System.out.println("\t[1] - Add Ingredient");
            System.out.println("\t[2] - Remove Ingredient");
            System.out.println("\t[3] - Change Crust");
            System.out.println("\t[4] - Finish Editing Pizza");
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println();
        }while(option.compareTo("1") != 0 && option.compareTo("2") != 0
            && option.compareTo("3") != 0 && option.compareTo("4") != 0);
        return Integer.parseInt(option);
    }



    public String selectIngredient(LinkedList<Ingredient> ingredients){
        int i = 1;
        String option;
        System.out.println("-----------------------------------------------");
        System.out.println("\tSelect an ingredient");
        System.out.println("-----------------------------------------------");
        for(Ingredient ingredient: ingredients){
            System.out.println("\t[" + i + "] - " + ingredient.getName());
            i++;
        }
        do{
            System.out.print("Enter the ingredient name: ");
            option = scanner.nextLine();
            System.out.println();
            if(!isValidIngredient(option, ingredients)){
                System.out.println("Invalid ingredient. Enter the name of an ingredient from the list.");
            }else{
                break;
            }
        }while(true);
        return option;
    }

    private boolean isValidIngredient(String ingredientName, LinkedList<Ingredient> ingredients){
        for (Ingredient ingredient: ingredients) {
            if(ingredientName.compareTo(ingredient.getName()) == 0) return true;
        }
        return false;
    }

    public String requestCustomerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public String requestCustomerPhone() {
        String phone;
        String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        Pattern pattern = Pattern.compile(allCountryRegex);

        do{
            System.out.print("Enter your phone number: ");
            phone = scanner.nextLine();
            Matcher matcher = pattern.matcher(phone);
            if (!matcher.matches()) {
                System.out.println("Invalid phone number. Enter a valid phone number containing the country extension.");
            }else{
                break;
            }
        }while(true);
        return phone;
    }

    public String requestCustomerAddress() {
        System.out.print("Enter your address: ");
        return scanner.nextLine();
    }

    public int requestCustomerAge() {
        String input;
        int age;
        do{
            System.out.print("Enter your age: ");
            input = scanner.nextLine();
            try{
                age = Integer.parseInt(input);
                break;
            }catch (NumberFormatException e){
                System.out.println("Invalid age. Please enter a number");
            }

        }while(true);
        return age;
    }

    public boolean requestFirstOrder() {
        String option;
        System.out.println("Is this your first order?");
        System.out.println("\t[1] - Yes");
        System.out.println("\t[2] - No");
        do{
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println();
            if (option.compareTo("1") == 0 || option.compareTo("2") == 0) {
                break;
            }else{
                System.out.println("Invalid input. Enter either 1 to say yes or 2 to say no.");
            }
        }while(true);
        return option.compareTo("1") == 0;
    }

    public void showClientView() {
        System.out.println("-----------------------------------------------");
        System.out.println("\tClient details");
        System.out.println("-----------------------------------------------");
    }

    public String editCrust(Iterator crustIterator) {
        String option;
        LinkedList<String> crustCopy = new LinkedList<>();
        System.out.println("-----------------------------------------------");
        System.out.println("\tSelect a Crust");
        System.out.println("-----------------------------------------------");
        for(int i = 1; crustIterator.hasNext(); i++){
            String crust = (String) crustIterator.next();
            crustCopy.add(crust);
            System.out.println("\t[" + i + "] - " + crust);
        }
        do{
            System.out.print("Enter crust name: ");
            option = scanner.nextLine();
            System.out.println();
            if(!isValidCrust(option, crustCopy)){
                System.out.println("Invalid option. To select a crust enter its name.");
            }else{
                break;
            }
        }while(true);
        return option;
    }

    private boolean isValidCrust(String currCrust, LinkedList<String> crusts){
        for(String crust : crusts){
            if(crust.compareTo(currCrust) == 0) return true;
        }
        return false;
    }

    public void showOrderResume(CompositeOrder compositeOrder, Customer customer) {
        System.out.println("-----------------------------------------------");
        System.out.println("\tOrder Summary");
        System.out.println("-----------------------------------------------");
        compositeOrder.print();
        System.out.println("-----------------------------------------------");
        System.out.println("\tCustomer Summary");
        System.out.println("-----------------------------------------------");
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer phone: " + customer.getPhoneNumber());
        System.out.println("Customer address: " + customer.getDeliveryAddress());
        System.out.print("Customer first order: ");
        if(customer.isFirstOrder()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        switch (customer.getDelegationID()) {
            case 0 -> System.out.println("Customer ordered in: Barcelona");
            case 2 -> System.out.println("Customer ordered in: Tarragona");
            case 1 -> System.out.println("Customer ordered in: Girona");
            case 3 -> System.out.println("Customer ordered in: Lleida");
        }
    }

    public void showMissingIngredients() {
        System.out.println("The Pizza has no more ingredients to remove.");
    }
}
