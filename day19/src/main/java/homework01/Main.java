package homework01;

import javax.crypto.MacSpi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  使用线程池实现买票案例  并统计  各个窗口卖出的票数
 */
public class Main {
    private static int tickets = 100000;
    private static int THREAD_NUM = 1;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        Callable<Map> callable = new Callable<>() {
//            private int sum = 0;
            private Map<String,Integer> map = new HashMap<>();

            ReentrantLock lock = new ReentrantLock();

            @Override
            public Map<String, Integer> call() throws Exception {


                //双重校验锁，不然可能产生超卖问题
                //lock必须是同一把，不能放在while 里面new
                while (tickets > 0){
                    lock.lock();
                    try {
                        if (tickets > 0 ) {
                            System.out.println(Thread.currentThread().getName() + "：\t" + tickets);
                            //模拟卖票
                            decrTicket();
                            //卖票数

                            int value = map.get(Thread.currentThread().getName()) == null ? 0:map.get(Thread.currentThread().getName());
                            map.put(Thread.currentThread().getName(),++value);
//                            sum++;
                        }
                    }finally {
                        lock.unlock();
                    }

                }

                return map;
            }
        };

        Future<Map> result = null;
        long begin = System.currentTimeMillis();
        for (int i = 0; i <= THREAD_NUM; i++) {
            result = executorService.submit(callable);
        }

        //为什么这里会在子线程执行完后再执行
        System.out.println("result = " + result.get());
        System.out.println( System.currentTimeMillis() - begin );
        executorService.shutdown();


//        System.out.println("result = " + result);
//        executorService.shutdown();
//        Future<Map> submit = executorService.submit(callable);
//        System.out.println("submit = " + submit.get());
    }


    public static void decrTicket(){
        tickets--;
    }
}
