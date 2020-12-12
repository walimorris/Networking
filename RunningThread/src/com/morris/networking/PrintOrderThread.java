package com.morris.networking;

/**
 * This is a leetcode challenge: The same instance of Foo will be passed three different
 * threads. Thread A will call first(), thread B will call second(), and thread C will
 * call third(). Design a mechanism and modify the program to ensure that second() is
 * executed after first(), and third() is executed after second().
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class PrintOrderThread {
    private boolean firstExecuted;
    private boolean secondExecuted;

    public PrintOrderThread() {
        firstExecuted = false;
        secondExecuted = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstExecuted = true;


    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!firstExecuted) {
            continue;
        }
        printSecond.run();
        secondExecuted = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while(!secondExecuted) {
            continue;
        }
        printThird.run();
    }
}
