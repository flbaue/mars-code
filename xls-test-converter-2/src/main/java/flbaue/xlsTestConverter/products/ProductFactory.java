/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.xlsTestConverter.products;

/**
 *
 * @author florianbauer
 */
public class ProductFactory {

    public static Product getProduct(String product) {

        if (product != null) {
            for (Product p : Product.values()) {
                for (String name : p.getNames()) {
                    if (product.contains(name)) {
                        return p;
                    }
                }
            }
        }

        throw new UnsupportedOperationException("Product: \"" + product + "\" is not supported");
    }
}
