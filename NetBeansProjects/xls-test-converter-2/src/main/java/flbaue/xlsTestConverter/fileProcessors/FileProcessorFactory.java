/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.xlsTestConverter.fileProcessors;

import flbaue.xlsTestConverter.products.Product;

/**
 *
 * @author florianbauer
 */
public class FileProcessorFactory {

    public static FileProcessor getProcessor(Product product) {

        if (Product.LOTTO_NORMAL.equals(product)) {
            return new LottoProcessor();
        } else if (Product.LOTTO_SYSTEM.equals(product)) {
            return new LottoProcessor();
        } else {
            throw new UnsupportedOperationException("Product: \"" + product + "\" is not supported");
        }

    }
}
