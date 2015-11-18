package kr.co.ioacademy;

// 스레드의 중단 및 종료 처리
// 1. 스레드를 만들고 시작하는 것은 쉬운 일이다.
// 2. 스레드를 안전하고 빠르게 멈추게 하는 것은 어렵다.
// 3. 자바의 스레드를 멈추는 기능이 폐기되었다.
//   Thread.stop() / Thread.suspend()

// 4. 스레드를 강제로 종료하면 공유되어 있는 여러 가지 상태가
//    망가질 수 있다.
// 5. 스레드를 멈춰달라는 요청이 오면 진행 중이던 모든 작업을 정리한 후
//    스스로 종료하도록 만들어야 한다.


import java.util.concurrent.TimeUnit;

/*
public class Example4 {
    private static boolean stopRequested = false;
    // 문제점 : main 스레드가 변경한 stopRequested 의 새로운 값을 background
    //        thread 가 관측할 수 없다.
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!stopRequested) {
                    i++;
                    // System.out.println("value - "  + i);
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
    }

}
*/

// 문제점 : main 스레드가 변경한 stopRequested 의 새로운 값을 background
//        thread 가 관측할 수 없다.

// 해결책 1. 동기화(synchronization)
// 1) 상호 배제 : 다른 스레드가 변경 중인 객체의 상태를 관측할 수 없도록 해준다. - 락
// 2) 동기화는 동기화 메소드 또는 동기화 블록에 의해 진입한 스레드가 동일한 락의 보호 아래
//    이루어진 모든 변경을 관측할 수 있다.

// 문제점 : 순환문의 각 단계마다 동기화를 실행하는 비용이 크다.

/*
public class Example4 {
    private static synchronized void stop() { stopRequested = true; }
    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    private static boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!isStopRequested()) {
                    i++;
                    // System.out.println("value - "  + i);
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stop();
        // stopRequested = true;
    }
}
*/

// http://d.pr/n/1lxnq
// cv 제한자(const-volatile) : C, C++, C# - Debug / [Release]

// 해결책 2. volatile
// 정의 : 컴파일러가 최적화를 하지 말라는 지시어
//   멀티 스레드 상에서 공유되는 변수, 하드웨어와 연결된 변수 사용시
//   되도록 volatile 붙이자.
// 효과 : 어떤 스레드건 가장 최근에 기록된 값을 읽을 수 있다.
public class Example4 {
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!stopRequested) {
                    i++;
                    // System.out.println("value - "  + i);
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
    }

}







