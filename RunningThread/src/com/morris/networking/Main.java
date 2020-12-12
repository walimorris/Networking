package com.morris.networking;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        Runnable run = () -> System.out.println("Running!");
        MyRunningThread thread = new MyRunningThread(run, 10);
        thread.run();

        /* One way to invoke the Callable Interface's call() method, but there are more
         * creative ways.
         */
        int[] nums = {2, 4, 12, 1, 7, 11};
        FindMaxTask maxTask = new FindMaxTask(nums, 0, nums.length);
        Integer result = 0;
        try {
            result = maxTask.call();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println(result);

        /* In this case, the code is much smaller and the implementation is hidden
         * from users of the MultiThreadedMaxFinder class. Lastly, implementation
         * is very fast as each subarray is searched at the same time! Think of
         * searching a very large array.
         */
        try {
            System.out.println(MultiThreadedMaxFinder.max(nums));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
