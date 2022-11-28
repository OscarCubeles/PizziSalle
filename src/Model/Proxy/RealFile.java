package Model.Proxy;

import Model.Entity.Menu;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

/**
    PATTERN: Proxy RealFile
 */
public class RealFile implements DataFile{
    private final String filename;
    private Menu menu;

    public RealFile(String filename){
         this.filename = filename;
         loadFile();
    }

    private void loadFile(){
        Gson gson = new Gson();
        // Reading the file
        try (Reader reader = new FileReader(filename)) {
            this.menu = gson.fromJson(reader, (Type) Menu.class);
        } catch (IOException e) {
            System.out.println("Error. Unable to load pizza data.");
        }
        System.out.println();
    }

    @Override
    public Menu getMenu() {
        return menu;
    }
}
