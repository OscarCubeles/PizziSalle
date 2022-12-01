package Model.Proxy;

import Model.Entity.Menu;
import Model.Entity.Pizza;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

/**
 * PATTERN: Proxy
 */
public class RealFile implements DataFile {
    private final String filename;
    private Menu menu;
    private Pizza pizza;

    public RealFile(String filename, boolean isSinglePizza) {
        this.filename = filename;
        if (isSinglePizza) {
            loadDelegationPizza();
        } else {
            loadPizzasFile();
        }
    }

    private void loadPizzasFile() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            this.menu = gson.fromJson(reader, (Type) Menu.class);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error. Unable to load pizza data.");
        }
        System.out.println();
    }

    private void loadDelegationPizza() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            this.pizza = gson.fromJson(reader, (Type) Pizza.class);
        } catch (IOException e) {
            System.out.println("Error. Unable to load pizza data.");
        }
        System.out.println();
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public Pizza getDelegationPizza() {
        return pizza;
    }
}
