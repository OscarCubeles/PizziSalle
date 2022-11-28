package Model.Composite;

import Model.Entity.Drink;
import Model.Entity.Pizza;

import java.awt.*;
import java.util.ArrayList;

/**
 * PATTERN: Composite
 */
public class CompositeOrder implements Order{

    private final ArrayList<Order> childOrder = new ArrayList<>();

    public void add(Order order){
        childOrder.add(order);
    }

    @Override
    public void print() {
        for (Order order: childOrder) {
            order.print();
        }
    }

    private void compositeExample(){
        Pizza pizza1 = new Pizza("hola");
        Pizza pizza2 = new Pizza("hol1");
        Pizza pizza3 = new Pizza("hol3");

        CompositeOrder compositeOrder = new CompositeOrder();
        compositeOrder.add(pizza1);
        compositeOrder.add(pizza2);
        compositeOrder.add(pizza3);

        CompositeOrder compositeOrder1 = new CompositeOrder();
        compositeOrder1.add(new Drink("Monster"));
        compositeOrder.add(compositeOrder1);
        compositeOrder.print();
    }
}
