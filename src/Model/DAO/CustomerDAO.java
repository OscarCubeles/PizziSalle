package Model.DAO;

import Model.Entity.Customer;
import Model.Entity.Customers;
import Model.Entity.Pizza;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Optional;

public class CustomerDAO implements DAO{

    Customers customers;

    public CustomerDAO() {
        Gson gson = new Gson();
        // Reading the file
        try (Reader reader = new FileReader("rsc/datasets/customers.json")) {
            this.customers = gson.fromJson(reader, (Type) Customers.class);
        } catch (IOException e) {
            this.customers = new Customers();
        }

    }


    @Override
    public Optional<Customer> get(String name) {
        return Optional.empty();
    }

    @Override
    public LinkedList<Customer> getAll() {
        return  customers.getCustomers();
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("rsc/datasets/customers.json")) {
            gson.toJson(customers, writer);
        } catch (IOException e) {
            System.out.println("Error. The system was unable to store the customer.");
        }
        System.out.println();
    }
}
