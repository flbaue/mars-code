/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.lotto.system.gen;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author florianbauer
 */
public class Combination {
    
    private int[] numbers;
    
    public Combination() {
        this.numbers = new int[6];
    }
    
    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }
    
    public void setNumbers(int[] numbers) {
        this.numbers = Arrays.copyOf(numbers, this.numbers.length);
        Arrays.sort(this.numbers);
    }
    
    @Override
    public boolean equals(Object other) {
        
        if (other == null) {
            return false;
        }
        
        if (other == this) {
            return true;
        }
        
        if (other.getClass() != this.getClass()) {
            return false;
        }
        
        Combination combination = (Combination) other;
        
        if (Arrays.equals(this.numbers, combination.getNumbers())) {
            return true;
        }
        
        return false;
        
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Arrays.hashCode(this.numbers);
        return hash;
    }
}
