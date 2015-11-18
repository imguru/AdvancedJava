package kr.co.ioacademy;

// 1 억 만들기

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

// value += 2; -> Atomic 하지 않다.
// 1. value 를 메모리부터 로드
// 2. 2를 더하고
// 3. 메모리에 저장

public class Example5 {
    private static final int THREAD_COUNT = 2;

    private static AtomicLong value1 = new AtomicLong(0);
    // private static volatile long value = 0;

    private final static Runnable TASK = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                value1.addAndGet(2);
                // value += 2;
        }
    };

    @Test
    public void perf1() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK);

        for (Thread t : threads)
            t.start();

        boolean alive = true;
        while (alive) {
            for (Thread t : threads) {
                t.join(10);
                if (alive = t.isAlive())
                    break;
            }
        }

        System.out.println("value : " + value1.get());
    }

    private static volatile long value2 = 0;
    private final static Runnable TASK2 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                synchronized (Example5.class) {
                    value2 += 2;
                }
        }
    };
    @Test
    public void perf2() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK2);

        for (Thread t : threads)
            t.start();

        boolean alive = true;
        while (alive) {
            for (Thread t : threads) {
                t.join(10);
                if (alive = t.isAlive())
                    break;
            }
        }

        System.out.println("value : " + value2);
    }

    private static volatile long value3 = 0;
    private final static Runnable TASK3 = new Runnable() {
        @Override
        public void run() {
            long local_sum = 0;
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                local_sum += 2;

            synchronized (Example5.class) {
                value3 += local_sum;
            }
        }
    };
    @Test
    public void perf3() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK3);

        for (Thread t : threads)
            t.start();

        boolean alive = true;
        while (alive) {
            for (Thread t : threads) {
                t.join(10);
                if (alive = t.isAlive())
                    break;
            }
        }

        System.out.println("value : " + value3);
    }
}








