/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wangzhe 2018/2/7.
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<FutureTask<String>> futureTasks = new ArrayList<>();

        for (int i = 0; i <100; i++) {

            int finalI = i;

            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName()+" sleep...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" sleep done!");
                    return finalI +"";
                }
            };
            FutureTask<String> futureTask = new FutureTask<>(callable);
            futureTasks.add(futureTask);
            Thread t = new Thread(futureTask);
            t.start();

        }

        String result = "";
        for(FutureTask<String> futureTask:futureTasks)
        {
            result = result+futureTask.get();
        }
        System.out.println(result);


    }
}
