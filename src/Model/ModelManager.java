package Model;

import Model.Composite.CompositeOrder;
import Model.Composite.Order;
import Model.DAO.CustomerDAO;
import Model.Entity.Customer;
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
   }

    public CompositeOrder getCompositeOrder() {
        return compositeOrder;
    }

    public void addToOrder(Order order){
       compositeOrder.add(order);
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
       return customer;
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
        for (Customer customerDB: customerDAO.getAll()) {
            if(customerDB.getName().compareTo(customer.getName()) == 0){
                return;
            }
        }
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

    public void setCustomerAge(int age) {
       customer.setAge(age);
    }
}
