
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lars
 */
public class Category {
    
    private final String name;
    private final List<Product> productlist;

    public Category(String name) {
        this.name = name;
        this.productlist = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductlist() {
        return productlist;
    }

}
