package com.morris.networking;

public class Main {

    public static void main(String[] args) {
        Runnable run = () -> System.out.println("Running!");
        MyRunningThread thread = new MyRunningThread(run, 10);
        thread.run();
    }
}
