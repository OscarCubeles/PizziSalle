package Model;

import Model.Entity.Drink;
import Model.Entity.Menu;
import Model.Entity.Pizza;
import Model.Proxy.ProxyFile;

import java.util.LinkedList;

/**
    PATTERN: Singleton
 */
public class DataSingleton {
    private static DataSingleton dbObject;

    private final Menu data;

    private DataSingleton() {
        data = new ProxyFile("rsc/datasets/Menu.json").getMenu();
    }

    public static DataSingleton getInstance() {
         if(dbObject == null) {
            dbObject = new DataSingleton();
        }
        return dbObject;
    }

    public Menu getData() {
        return data;
    }

    public LinkedList<Pizza> getPizzas(){
        return data.getPizzas();
    }

    public LinkedList<Drink> getDrinks(){
        return data.getBeverages();
    }

    public LinkedList<String> getCrusts(){
        return data.getCrust();
    }

    public LinkedList<String> getIngredients(){
        return data.getIngredients();
    }
}
