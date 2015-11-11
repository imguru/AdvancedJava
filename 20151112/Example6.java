package kr.co.ioacademy;

// 스레드의 중단 및 종료 처리
// 1. 스레드를 시작하는 것은 쉽다.
// 2. 스레드를 안전하고 빠르고 안정적으로 멈추게 하는 것은 어렵다.
// 3. 자바에는 스레드를 멈추는 기능이 폐기되었다.
//     Thread.stop(), Thread.suspend();
// 4. 스레드를 강제로 종료하면, 공유되어 있는 여러가지 상태가 비정상적인 상태에 놓일 수 있다.
// 5. 스레드를 멈춰달라는 요청을 받으면 진행 중이던 작업을 모든 정리한 다음 종료하도록 만들어야 한다

import java.util.concurrent.TimeUnit;


// 문제점: main 스레드가 변경한 stopRequest의 새로운 값을 백그라운드 스레드가 언제 확인할 지 보장할 수 없다.
/*
public class Example7 {
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
*/

// 해결책 : 동기화(synchronize)
// 1) 상호 배제 : 다른 스레드가 변경 중인 객체의 상태를 관측할 수 없도록 해준다.
//   "객체는 일관된 상태를 갖도록 생성되며 해당 객체를 접근하는 메소드는 그 객체에 락을 건다.
//   "락을 건 메서드는 객체의 상태를 관측할 수 있으며, 선택적으로 객체의 상태도 변경 할 수 있다
// 2) 동기화는 동기화 메소드는 동기화 블록에 진입한 스레드가 동일한 락의 보호 아래 이루어진 모든 변경을
//    관측할 수 있도록 해준다.
//    -> 읽기/쓰기 연산에 전부 적용되어야 한다.

// 문제점 : 순환문의 각 단계마다 동기화를 실행하는 비용이 크다
/*
public class Example7 {
    private static boolean stopRequested;

    //---
    private static synchronized void stop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }
    //---

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!stopRequested()) {
                    i++;
                    // System.out.println("value : " + i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stop();
    }
}
*/


// 해결책 2. volatile
// volatile
// 정의 : 컴파일러에게 최적화 하지 말라는 지시어
//       멀티 스레드 환경에서 공유되는 변수, 하드웨어와 연결된 변수 사용시
//       되도록이면 volatile을 붙이자.!!!
// 효과 : 어떤 스레드건 가장 최근에 기록된 값을 읽도록 보장한다.

public class Example7 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!stopRequested) {
                    i++;
                    // System.out.println("value : " + i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
    }
}






