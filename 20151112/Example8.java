import org.junit.Test;

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

