package Model;

import Model.Entity.Pizza;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ModelManager {
    @Expose
    private ArrayList<Pizza> pizzas;
    public ModelManager()  {

    }

    public void readData(){
        Pizza pizzas;
        String filename = ("rsc/datasets/Menu.json");
        Gson gson = new Gson();
        ModelManager jsonInfo = new ModelManager();

        // Reading the file
        try (Reader reader = new FileReader(filename)) {
            jsonInfo = gson.fromJson(reader, (Type) ModelManager.class);

        } catch (IOException e) {
            // Printing an error message informing that it was not possible to read the file
            System.out.println("There was an error processing the file competicio.json .");
        }
        System.out.println();
    }
}
