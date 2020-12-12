package com.morris.networking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedMaxFinder {

    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if (data.length == 1) {
            return data[0];
        } else {
            if (data.length == 0) {
                throw new IllegalArgumentException("Array with no elements");
            }
        }

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        /* Should explicitly call ExecutorService's shutdown() method, otherwise the
         * service continues to run(wait for more tasks to complete on the open threads).
         */
        service.shutdown();

        return Math.max(future1.get(), future2.get());
    }
}
