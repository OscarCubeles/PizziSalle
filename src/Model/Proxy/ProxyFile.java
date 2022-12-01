package Model.Proxy;

import Model.Entity.Menu;
import Model.Entity.Pizza;

/**
    PATTERN: Proxy ProxyFile
 */
public class ProxyFile implements DataFile {

    private final String filename;
    private RealFile realFile;


    public ProxyFile(String filename){
        this.filename = filename;
    }

    @Override
    public Menu getMenu() {
        if(realFile == null){
            realFile = new RealFile(filename, false);
        }
        return realFile.getMenu();
    }

    @Override
    public Pizza getDelegationPizza() {
        if(realFile == null){
            realFile = new RealFile(filename, true);
        }
        return realFile.getDelegationPizza();
    }


}
