import Controller.MainController;
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
import View.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ModelManager model = new ModelManager();
        View view = new View();
        MainController controller = new MainController(view, model);
        controller.start();
    }

    //template pattern per llegir les diferents coses
    //fer logs a un file rollo tal restaurant ha fet un pedido, copiar el https://refactoring.guru/design-patterns/observer
    //strategy pattern to avoid switch of places
    // iterator to traverse dishes in the order
}