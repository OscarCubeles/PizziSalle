package Model.Entity;

import Model.Composite.Order;
/**
 * PATTERN: Composite
 */
public class Drink implements Order {
    private final String name;
    private final int minAge;

    public Drink(String name) {
        this.name = name;
        this.minAge = 0;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    @Override
    public void print() {
        System.out.println("Drink name: " + name);
    }
}
