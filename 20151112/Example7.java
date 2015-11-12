package kr.co.ioacademy;

// 1억 만들기.
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Example7 {
    private static final int THREAD_COUNT = 5;

    private static AtomicInteger atomicInteger = new AtomicInteger();
    private final static Runnable TASK1 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                atomicInteger.addAndGet(2);
        }
    };

    @Test
    public void perf1() throws InterruptedException {
        atomicInteger.set(0);

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK1);

        for (Thread t : threads) {
            t.start();
        }

        boolean alive = true;
        while (alive) {
            for (Thread t : threads) {
                t.join(10);
                if (alive = t.isAlive())
                    break;
            }
        }

        System.out.println("value : " + atomicInteger.get());
    }

}