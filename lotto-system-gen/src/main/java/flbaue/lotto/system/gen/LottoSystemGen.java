/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.lotto.system.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author florianbauer
 */
public class LottoSystemGen {

    private int[] numbers;

    public static void main(String[] args) {

        LottoSystemGen lsg = new LottoSystemGen(args);
        lsg.run();
    }

    private LottoSystemGen() {
    }

    public LottoSystemGen(String[] args) {
        this.numbers = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.valueOf(args[i]);
        }

        Arrays.sort(numbers);

    }

    public void run() {

        List<List<Integer>> com = combinations(numbers, 0, 6);

        System.out.println("Menge: " + com.size());
        System.out.println(com);

    }

    private List<List<Integer>> combinations(int[] array, int startingIndex, int combinationLenght) {

        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (combinationLenght == 2) {

            int combinationsListIndex = 0;
            for (int arrayIndex = startingIndex; arrayIndex < array.length; arrayIndex++) {

                for (int i = arrayIndex + 1; i < array.length; i++) {

                    //add new List in the list to hold the new combination
                    combinations.add(new ArrayList<Integer>());

                    //add the starting index element from "array"
                    combinations.get(combinationsListIndex).add(array[arrayIndex]);
                    while (combinations.get(combinationsListIndex).size() < combinationLenght) {

                        //add until we come to the length of the combination
                        combinations.get(combinationsListIndex).add(array[i]);
                    }
                    combinationsListIndex++;
                }

            }

            return combinations;
        }

        List<List<Integer>> combinationsofMore = new ArrayList<List<Integer>>();
        for (int i = startingIndex; i < array.length - combinationLenght + 1; i++) {
            //generate combinations of lenght-1(if lenght > 2 we enter into recursion)
            combinations = combinations(array, i + 1, combinationLenght - 1);

            //add the starting index Elemetn in the begginnig of each newly generated list
            for (int index = 0; index < combinations.size(); index++) {
                combinations.get(index).add(0, array[i]);
            }

            for (int y = 0; y < combinations.size(); y++) {
                combinationsofMore.add(combinations.get(y));
            }
        }

        return combinationsofMore;
    }
}
