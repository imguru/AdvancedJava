package kr.co.ioacademy;

import org.junit.Test;
import sun.misc.Contended;

class C {
    public final static int NUM_THREADS = 8;
    public final static long ITERATIONS = 50L * 1000L * 1000L;
}

// 가짜 공유 문제(False Sharing)
// 개념 : 두 스레드간의 공유가 발생하지 않음에도 캐시라인의 공유에 의해서
//   서로의 캐시를 무효화함으로 성능이 저하되는 문제.

public class Example6 {
    @Test
    public void runTest() throws InterruptedException {
        Thread[] threads = new Thread[C.NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Task(i);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}

class Task extends Thread {
    static class Long {
        public volatile long value = 0L;
        public long p1, p2, p3, p4, p5, p6;
    }

    private static Long[] longs = new Long[C.NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++)
            longs[i] = new Long();
    }

    private int index;

    public Task(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        long i = C.ITERATIONS + 1;
        while (0 != --i) {
            longs[index].value = i;
        }
    }
}

