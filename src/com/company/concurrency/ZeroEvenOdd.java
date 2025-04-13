package com.company.concurrency;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private volatile int cnt;
    private Boolean isZero = true;
    private Boolean isOdd = true;
    private Boolean isEven = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.cnt = n;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        boolean iCan = true;
        while (iCan) {
            //synchronized (ZeroEvenOdd.class) {
            while (!isZero) {
                wait();
            }
            iCan = this.cnt > 0;
            if (iCan) {
                printNumber.accept(0);
                isZero = false;
                notifyAll();
            } else {
                break;
            }
        }
        isZero = false;
        isEven = true;
        isOdd = true;
        notifyAll();
    }


    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        boolean iCan = true;
        while (iCan) {
            //synchronized (ZeroEvenOdd.class) {
            while (isZero || !isEven) {
                wait();
            }
            iCan = this.cnt > 0;
            if (iCan) {
                this.cnt--;
                printNumber.accept(n - this.cnt);
                isZero = true;
                isEven = false;
                isOdd = true;
                notifyAll();
            } else {
                break;
            }
        }
        isOdd = true;
        isZero = false;
        notifyAll();
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        boolean iCan = true;
        while (iCan) {
            //synchronized (ZeroEvenOdd.class) {
            while (isZero || !isOdd) {
                wait();
            }
            iCan = this.cnt > 0;
            if (iCan) {
                this.cnt--;
                printNumber.accept(n - this.cnt);
                isOdd = false;
                isZero = true;
                isEven = true;
                notifyAll();
            } else {
                break;
            }

        }
        isEven = true;
        isZero = false;
        notifyAll();
    }
}
