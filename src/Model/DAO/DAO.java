package Model.DAO;

import Model.Entity.Customer;

import java.util.LinkedList;
import java.util.Optional;
/**
 * PATTERN: Data Access Object
 */
public interface DAO {

    Optional<Customer> get(String name);

    LinkedList<Customer> getAll();

    void save(Customer customer);

}
