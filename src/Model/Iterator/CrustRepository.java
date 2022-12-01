package Model.Iterator;
import Model.DataSingleton;
import java.util.LinkedList;

/**
 *     PATTERN: Iterator
 */
public class CrustRepository implements Container{
    private final LinkedList<String> crusts = DataSingleton.getInstance().getCrusts();

    @Override
    public Iterator getIterator() {
        return new CrustIterator();
    }

    private class CrustIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            return index < crusts.size();
        }

        @Override
        public Object next() {
            return this.hasNext() ? crusts.get(index++) : null;
        }
    }

}

