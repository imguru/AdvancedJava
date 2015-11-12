import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example9 {
    public final static int THREAD_POOL_SIZE = 16;

    public static Map<String, Integer> hashTableObject = null;
    public static Map<String, Integer> synchronizedMapObject = null;
    public static Map<String, Integer> concurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {
        hashTableObject = new Hashtable<String, Integer>();
        performTest(hashTableObject);

        synchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        performTest(synchronizedMapObject);

        concurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
        performTest(concurrentHashMapObject);
    }

    public static void performTest(final Map<String, Integer> map) throws InterruptedException {
        System.out.println("Test started for: " + map.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 500000; i++) {
                            Integer randomNumber = Integer.valueOf((int) Math.random());
                            Integer value = map.get(String.valueOf(randomNumber));

                            map.put(String.valueOf(randomNumber), randomNumber);
                        }
                    }
                });
            }

            executorService.shutdown();

            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + map.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
}
