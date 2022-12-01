package Model.DAO;

import Model.Entity.Customer;

import java.util.LinkedList;
import java.util.Optional;

public interface DAO {

    Optional<Customer> get(String name);

    LinkedList<Customer> getAll();

    void save(Customer customer);

}
