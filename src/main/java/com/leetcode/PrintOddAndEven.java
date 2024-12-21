package com.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintOddAndEven {
    public static int num = 0;
    public void printEven() {
        synchronized (this){
            while(num < 100){
                if(num %2 == 0){
                    System.out.println("No is : " + num);
                    num += 1;
                }else {
                    try{
                        wait(1000);
                    }catch (InterruptedException e){
                        log.info("Interrupted exception occurs");
                    }
                }
                notify();
            }
        }

    }

    public void printOdd() {
        synchronized (this){
            while (num < 100){
                if( num %2 != 0 ){
                    System.out.println("No is : " + num);
                    num += 1;
                }else{
                    try{
                        wait(1000);
                    }catch (InterruptedException e){
                        log.info("Interrupted exception occurs");
                    }
                }
                notify();
            }
        }
    }

    public static void main(String[] args) {
        PrintOddAndEven p = new PrintOddAndEven();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.printOdd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.printEven();
            }
        });
        t1.start();
        t2.start();
        /*try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
