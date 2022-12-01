package Model.Proxy;

import Model.Entity.Menu;
import Model.Entity.Pizza;

/**
    PATTERN: Proxy file
 */
public interface DataFile {
    Menu getMenu();
    Pizza getDelegationPizza();
}
