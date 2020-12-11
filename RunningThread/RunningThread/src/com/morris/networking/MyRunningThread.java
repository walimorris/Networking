package com.morris.networking;

import java.util.stream.IntStream;

/**
 * MyThread implements the {@link Runnable} interface, forcing it to implement the run()
 * method. MyThread also takes two parameters; a {@link Runnable} action which completes
 * that action n times when the run method is called on this thread.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class MyRunningThread implements Runnable {
    private final Runnable action;
    private final int n;

    public MyRunningThread(Runnable action, int n) {
        this.action = action;
        this.n = n;
    }

    @Override
    public void run() {
        IntStream.range(0, n + 1).forEach( x -> action.run());

    }
}
