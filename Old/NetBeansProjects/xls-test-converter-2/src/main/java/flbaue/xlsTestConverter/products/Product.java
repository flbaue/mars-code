/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.xlsTestConverter.products;

/**
 *
 * @author florianbauer
 */
public enum Product {

    LOTTO_NORMAL(new String[]{"lotto_normal"}),
    LOTTO_SYSTEM(new String[]{"lotto_vew", "lotto_voll"});
    
    private String[] names;

    private Product(String[] names) {
        setNames(names);
    }

    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    private void setNames(String[] names) {
        this.names = names;
    }
}
