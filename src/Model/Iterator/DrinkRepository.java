package Model.Iterator;

import Model.DataSingleton;
import Model.Entity.Drink;

import java.util.LinkedList;
/**
 *     PATTERN: Iterator
 */
public class DrinkRepository implements Container{

    private final LinkedList<Drink> drinks = DataSingleton.getInstance().getDrinks();

    @Override
    public Iterator getIterator() {
        return new DrinksIterator();
    }

    private class DrinksIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            return index < drinks.size();
        }

        @Override
        public Object next() {
            return this.hasNext() ? drinks.get(index++) : null;
        }
    }

}

