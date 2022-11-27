package Model;

import Model.Entity.Menu;

/*
    PATTERN: Singleton
 */
public class DataSingleton {
    private static DataSingleton dbObject;

    private final Menu data;

    private DataSingleton() {
        data = new ProxyFile("rsc/datasets/Menu.json").getMenu();
    }

    public static DataSingleton getInstance() {

        // create object if it's not already created
        if(dbObject == null) {
            dbObject = new DataSingleton(); // pillar el object de la proxy
        }

        // returns the singleton object
        return dbObject;
    }

    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}
