package Model;

import Model.Composite.CompositeOrder;
import Model.Composite.Order;
import Model.Entity.Drink;
import Model.Entity.Ingredient;
import Model.Entity.Pizza;
import Model.Iterator.CrustRepository;
import Model.Iterator.DrinkRepository;
import Model.Iterator.Iterator;
import Model.Iterator.PizzaRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.spi.CurrencyNameProvider;

public class ModelManager {
   PizzaRepository pizzaRepository;
   CrustRepository crustRepository;
   DrinkRepository drinkRepository;
   LinkedList<Ingredient> ingredients;

   CompositeOrder compositeOrder;

   public ModelManager(){
       pizzaRepository = new PizzaRepository();
       crustRepository = new CrustRepository();
       drinkRepository = new DrinkRepository();
       ingredients = DataSingleton.getInstance().getIngredients();
       compositeOrder = new CompositeOrder();
   }

   public void addToOrder(Order order){
       compositeOrder.add(order);
   }

   public void printIterators(){
       for(Iterator iter = pizzaRepository.getIterator(); iter.hasNext();){
           Pizza pizza = (Pizza) iter.next();
           System.out.println(pizza.getName());
       }

       for(Iterator iter = drinkRepository.getIterator(); iter.hasNext();){
           Drink pizza = (Drink) iter.next();
           System.out.println(pizza.getName());
       }

       for(Iterator iter = crustRepository.getIterator(); iter.hasNext();){
           String crust = (String) iter.next();
           System.out.println(crust);

       }
   }

   public Iterator getPizzaIterator(){
       return pizzaRepository.getIterator();
   }

    public Iterator getDrinkIterator(){
       return drinkRepository.getIterator();
    }

    public Iterator getCrustIterator(){
       return crustRepository.getIterator();
    }

    public LinkedList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Pizza getPizza(int pizzaIndex) {
       int i = 1;
       Iterator iter = pizzaRepository.getIterator();
       while(iter.hasNext()){
           Pizza currPizza = (Pizza) iter.next();
           if(pizzaIndex == i){
               return currPizza;
           }
           i++;
        }
       return null;
    }
}
