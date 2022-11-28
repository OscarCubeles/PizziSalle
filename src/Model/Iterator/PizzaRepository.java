package Model.Iterator;

import Model.DataSingleton;
import Model.Entity.Pizza;

import java.util.LinkedList;
/**
 *     PATTERN: Iterator
 */
public class PizzaRepository implements Container{

    private final LinkedList<Pizza> pizzas = DataSingleton.getInstance().getPizzas();

    @Override
    public Iterator getIterator() {
        return new PizzaIterator();
    }

    private class PizzaIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            return index < pizzas.size();
        }

        @Override
        public Object next() {
            return this.hasNext() ? pizzas.get(index++) : null;
        }
    }

}
