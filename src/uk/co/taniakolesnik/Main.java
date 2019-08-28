package uk.co.taniakolesnik;


public class Main {

    public static void main(String[] args) {

        Thread [] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new FactorialThread(i));
            threads[i].start();
        }
    }
}