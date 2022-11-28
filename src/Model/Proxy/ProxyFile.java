package Model.Proxy;

import Model.Entity.Menu;

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
            realFile = new RealFile(filename);
        }
        return realFile.getMenu();
    }
}
