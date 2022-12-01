package Model;

import Model.Composite.CompositeOrder;
import Model.Composite.Order;
import Model.DAO.CustomerDAO;
import Model.Entity.Customer;
import Model.Entity.Drink;
import Model.Entity.Ingredient;
import Model.Entity.Pizza;
import Model.Iterator.CrustRepository;
import Model.Iterator.DrinkRepository;
import Model.Iterator.Iterator;
import Model.Iterator.PizzaRepository;

import java.util.LinkedList;

public class ModelManager {
   PizzaRepository pizzaRepository;
   CrustRepository crustRepository;
   DrinkRepository drinkRepository;
   LinkedList<Ingredient> ingredients;
   CompositeOrder compositeOrder;
   Customer customer;
   CustomerDAO customerDAO;

   public ModelManager(){
       pizzaRepository = new PizzaRepository();
       crustRepository = new CrustRepository();
       drinkRepository = new DrinkRepository();
       ingredients = DataSingleton.getInstance().getIngredients();
       compositeOrder = new CompositeOrder();
       customer = new Customer();
       customerDAO = new CustomerDAO();
       System.out.println();
   }

    public CompositeOrder getCompositeOrder() {
        return compositeOrder;
    }

    public void addToOrder(Order order){
       compositeOrder.add(order);
   }

   public void printOrder(){
       compositeOrder.print();
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

    public Customer getCustomer() {
       return new Customer();
    }

    public void setCustomerName(String name) {
       customer.setName(name);
    }
    public void setCustomerPhone(String phone) {
        customer.setPhoneNumber(phone);
    }

    public void setCustomerAddress(String address) {
       customer.setDeliveryAddress(address);
    }

    public void storeCustomerDB() {
        customerDAO.save(customer);
    }


    public void addDelegation(int delegationIndex) {
       pizzaRepository.addDelegationPizza(delegationIndex);
    }

    public void setCustomerIsFirstOrder(boolean requestFirstOrder) {
       customer.setIsFirstOrder(requestFirstOrder);
    }

    public void setCustomerDelegation(int delegationId){
       customer.setDelegationID(delegationId);
    }
}
