package uk.co.taniakolesnik;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100);
        }
        //System.out.println(Arrays.toString(array));
        SumCaller sumCaller = new SumCaller();
        sumCaller.init(array);
    }

}