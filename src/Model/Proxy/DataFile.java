package Model.Proxy;

import Model.Entity.Menu;
import Model.Entity.Pizza;

/**
    PATTERN: Proxy
 */
public interface DataFile {
    Menu getMenu();
    Pizza getDelegationPizza();
}
