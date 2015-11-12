package kr.co.ioacademy;


import java.util.concurrent.TimeUnit;

public class Example6 {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!stopRequested) {
                    i++;
                    System.out.println("value : " + i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
    }
}





