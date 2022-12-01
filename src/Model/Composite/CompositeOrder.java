package Model.Composite;

import java.util.ArrayList;

/**
 * PATTERN: Composite
 */
public class CompositeOrder implements Order {

    private final ArrayList<Order> childOrder = new ArrayList<>();

    public void add(Order order) {
        childOrder.add(order);
    }

    @Override
    public void print() {
        for (Order order : childOrder) {
            order.print();
        }
    }
}
