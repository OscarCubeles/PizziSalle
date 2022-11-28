import Model.Composite.CompositeOrder;
import Model.DataSingleton;
import Model.Entity.Drink;
import Model.Entity.Pizza;
import Model.Iterator.CrustRepository;
import Model.Iterator.DrinkRepository;
import Model.Iterator.Iterator;
import Model.Iterator.PizzaRepository;
import Model.ModelManager;
import View.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ModelManager m = new ModelManager();
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


        SwingUtilities.invokeLater(() -> {
            MainFrame view = new MainFrame();
            view.setVisible(true);
        });
    }

    //template pattern per llegir les diferents coses
    //fer logs a un file rollo tal restaurant ha fet un pedido, copiar el https://refactoring.guru/design-patterns/observer
    //strategy pattern to avoid switch of places
    // iterator to traverse dishes in the order
}