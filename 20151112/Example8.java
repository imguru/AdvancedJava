import org.junit.Test;

// False Sharing
// 가짜 공유(False Sharing) 이야기
// 1. 두 스레드 간의 데이터 공유가 발생하는가? 즉 데이터 레이스 상황이 발생하는가?
//    공유되지 않기 때문에 락 또는 atomic operation은 쓸 필요가 없다.
// 2. False Sharing : 멀티 코어 시스템에서 일어날 수 있는 대표적인 성능 하락의 원인
//                    코어끼리 공유하지 않는 캐시에서 발생하는 문제                  
//                    서로 다른 데이터가 같은 캐시 라인 상에 올라와 있다면, 어느 한 쪽이 데이터를 쓰면
//                    다른 쪽 코어의 캐시 라인을 무효화 시킨다. 그래서 각 스레드가 데이터를 쓰려고 할 대마다
//                    서로의 캐시 라인을 무효화 시키기 때문에 성능 하락이 발생할 수 밖에 없다.

class C {
    public final static int NUM_THREADS = 8;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
}


public class Example8{
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

    @Test
    public void runTest2() throws InterruptedException {
        Thread[] threads = new Thread[C.NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Task2(i);
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

class Task2 extends Thread {
    static class Long2 {
        public volatile long value = 0L;
        public long p1, p2, p3, p4, p5, p6;

        // Java 8
        // @Contended
    }

    private static Long2[] longs = new Long2[C.NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++)
            longs[i] = new Long2();
    }

    private int index;

    public Task2(int index) {
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

