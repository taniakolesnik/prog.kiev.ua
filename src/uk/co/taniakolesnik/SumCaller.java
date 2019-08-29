package uk.co.taniakolesnik;

import java.util.ArrayList;
import java.util.Arrays;

public class SumCaller implements Callback{

    private int finalSum;

    public SumCaller() {
    }

    public void init(int[] array) {

        int chunk;
        if (array.length <= 100) {
            chunk = 50;
        } else if (array.length <= 100_000) {
            chunk = 1000;
        } else chunk = 10000;
        System.out.println("chunk is " + chunk);
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < array.length; i += chunk) {
            int[] subArray = Arrays.copyOfRange(array, i, Math.min(array.length, i + chunk));
            System.out.println(Arrays.toString(subArray));
            CalculateSumThread calculateSumThread = new CalculateSumThread(subArray, this);
            Thread thread = new Thread(calculateSumThread);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(finalSum);

    }

    @Override
    public void getSum(int sum) {
        finalSum += sum;
    }
}
