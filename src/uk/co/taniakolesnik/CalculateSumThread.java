package uk.co.taniakolesnik;

public class CalculateSumThread implements Runnable {

    private Callback callback;
    private int[] array;
    private int sum;

    public CalculateSumThread(int[] array, Callback callback) {
        this.array = array;
        sum=0;
        this.callback = callback;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        calculateSum(array);
    }

    private void calculateSum (int[] subArray){
        for (int i = 0; i < subArray.length; i++){
             sum += subArray[i];
        }
        callback.getSum(sum);
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
