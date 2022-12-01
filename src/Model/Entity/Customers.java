package Model.Entity;

import java.util.LinkedList;

public class Customers {
    LinkedList<Customer> customers;
    public Customers() {
        this.customers = new LinkedList<>();
    }
    public LinkedList<Customer> getCustomers() {
        return customers;
    }
    public void add(Customer customer){
        customers.add(customer);
    }
}
