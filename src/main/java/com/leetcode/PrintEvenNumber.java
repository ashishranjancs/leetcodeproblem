package com.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintEvenNumber {
    private Object lock;
    private int numb = MainForPrintNumber.number;

    public PrintEvenNumber(Object lock) {
        this.lock = lock;
    }

    public void printEven() {
        synchronized (lock){
            while(MainForPrintNumber.number < 100){
                if(MainForPrintNumber.number %2 == 0){
                    System.out.println("No is : " + MainForPrintNumber.number);
                    MainForPrintNumber.number += 1;
                    lock.notify();
                }else {
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
