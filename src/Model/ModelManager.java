package Model;

import Model.Entity.Drink;
import Model.Entity.Pizza;
import Model.Iterator.CrustRepository;
import Model.Iterator.DrinkRepository;
import Model.Iterator.Iterator;
import Model.Iterator.PizzaRepository;

import java.util.spi.CurrencyNameProvider;

public class ModelManager {
   PizzaRepository pizzaRepository;
   CrustRepository crustRepository;
   DrinkRepository drinkRepository;

   public ModelManager(){
       pizzaRepository = new PizzaRepository();
       crustRepository = new CrustRepository();
       drinkRepository = new DrinkRepository();
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



}
