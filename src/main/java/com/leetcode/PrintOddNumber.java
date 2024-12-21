package com.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintOddNumber {
    private int numb = MainForPrintNumber.number;
    private Object lock;

    public PrintOddNumber(Object lock) {
        this.lock = lock;
    }

    public void printOdd() {
        synchronized (lock){
            while (MainForPrintNumber.number < 10){
                if( MainForPrintNumber.number %2 != 0 ){
                    System.out.println("No is : " + MainForPrintNumber.number);
                    MainForPrintNumber.number += 1;
                    lock.notify();
                }else{
                    try{
                        lock.wait(1000);
                    }catch (InterruptedException e){
                        log.info("Interrupted exception occurs");
                    }
                }
            }
        }
    }
}
