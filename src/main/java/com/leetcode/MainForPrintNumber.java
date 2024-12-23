package com.leetcode;

public class MainForPrintNumber {
    public static int number = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) {
        PrintOddNumber od = new PrintOddNumber(lock);
        PrintEvenNumber ev = new PrintEvenNumber(lock);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                od.printOdd();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ev.printEven();
            }
        });

        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
