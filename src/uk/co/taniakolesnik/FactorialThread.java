package uk.co.taniakolesnik;

import java.math.BigInteger;

public class FactorialThread implements Runnable {

    private int value;

    public FactorialThread(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        BigInteger result = calcualateFactorial();
        System.out.println("Factorial for " + this.value + " is " + result + " (" + Thread.currentThread().getName() + ")");
    }

    private BigInteger calcualateFactorial(){
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= this.value; i++){
             factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }

        return factorial;
    }
}
