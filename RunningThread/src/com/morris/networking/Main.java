package com.morris.networking;

public class Main {

    public static void main(String[] args) {
        int x = 1;
        Runnable run = () -> System.out.println("Running!");
        MyRunningThread thread = new MyRunningThread(run, 10);
        thread.run();
    }
}
