import Model.DataSingleton;
import Model.Entity.Pizza;
import Model.ModelManager;
import View.MainFrame;
import com.google.gson.Gson;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        DataSingleton ds = DataSingleton.getInstance();



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                MainFrame view = new MainFrame();


                view.setVisible(true);
            }
        });
    }

    //template pattern per llegir les diferents coses
    //fer logs a un file rollo tal restaurant ha fet un pedido, copiar el https://refactoring.guru/design-patterns/observer
    //strategy pattern to avoid switch of places
    // iterator to traverse dishes in the order
}