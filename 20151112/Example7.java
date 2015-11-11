package kr.co.ioacademy;

// 병행성(Concurrency) vs 병렬성(Parallelism)
// 병행성 : 사전적 의미는 어떤 일들이 동시에 발생하는 것이다. 그러나 여기서 의미하는 병행성은
//         어떤 일들이 동시에 일어나는 것처럼 보이지만 실재로는 순차적으로 일어나는 것을 의미한다. 
//        병행성은 단일 프로세서 시스템에서 프로세스나 스레드가 동작하는 것을 의미한다.
// 병렬성 : 동시에 진행되는 병행적인 작업. 병렬성은 작업들이 동일한 방향으로 교차됨 없이 
//         독립적으로 진행되는 것을 의미한다. 
//         병렬성은 멀티 프로세서 시스템에서 프로세스나 스레드가
//         동시에 동작하는 것을 의미한다.


// 1억 만들기.
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Example8 {
    private static final int THREAD_COUNT = 5;

    private static AtomicInteger atomicInteger = new AtomicInteger();
    private final static Runnable TASK1 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                atomicInteger.addAndGet(2);
        }
    };

    private static int nextNumber = 0;
    private final static Runnable TASK2 = new Runnable() {
        private synchronized void add() {
            nextNumber += 2;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                add();
        }
    };


    private final static Runnable TASK3 = new Runnable() {
        private synchronized void add() {
            nextNumber += 2;
        }

        @Override
        public void run() {
            int localSum = 0;
            for (int i = 0; i < 50000000 / THREAD_COUNT; i++)
                localSum += 2;

            synchronized (Example8.class) {
                nextNumber += localSum;
            }
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

    @Test
    public void perf2() throws InterruptedException {
        nextNumber = 0;

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK2);

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

        System.out.println("value : " + nextNumber);
    }

    @Test
    public void perf3() throws InterruptedException {
        nextNumber = 0;

        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++)
            threads[i] = new Thread(TASK3);

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

        System.out.println("value : " + nextNumber);
    }
}