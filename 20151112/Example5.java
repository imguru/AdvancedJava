package kr.co.ioacademy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Example6 {
    /*
    public static void handleRequest(Socket connection) {
        OutputStream os = null;
        try {
            os = connection.getOutputStream();
            os.write("Hello World\n".getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        }
    }
    */

    // Try with Resource : Java 7
    // 1. Connection, Socket, InputStream, OutputStream 같은 자원을 개발자가
    // 직접 관리하는 것은 어렵다.
    // 2. try 블록에 존재하는 자원을 자동으로 회수해준다
    // 3. AutoCloseable 인터페이스를 구현해야 한다.
    public static void handleRequest(Socket connection) {
        try (OutputStream os = connection.getOutputStream()) {
            os.write("Hello World\n".getBytes());
            os.flush();
        } catch (IOException e) {
            // ...
        }
    }

    // Step 1. Single Thread Model
    // 1. 한번에 하나의 요청만을 처리하는 것이 가능하다.
    // 2. 단일 스레드에서 I/O 작업 등으로 대기하는 경우 하드웨어 자원을 효과적으로 활용할 수 없다.
    /*
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }
    */

    // Step 2. Thread per Connection Model
    //  순차적인 실행 방법에 비하면 동시에 여러 작업을 처리할 수 있다

    // 문제점
    // 1. 엄청나게 많은 스레드가 생성될 수 있다
    // 2. 스레드를 만들고 제거하는 작업에도 자원이 소모된다.(객체 생성 제거 비용)
    //    : 클라이언트의 요청이 작은 단위라면 빈번한 스레드 객체의 생성 소멸이 발생한다.
    // 3. 자원 낭비가 심하다.
    //  실행 중인 스레드는 시스템의 자원을 많이 소모한다.(메모리)  - Unix:8M, Windows:1M
    //  Java 의 스레드는 두 개의 스택을 갖는다(Java, Native)
    // 4. 프로세서 보다 많은 스레드가 만들어져 동작 중이면, 대부분의 스레드가 대기 상태에 있다.
    //  : 컨텍스트 스위칭의 비용이 크다.
    // 5. OS 마다 생성할 수 있는 스레드의 개수는 한계가 있다 (JVM 가용 메모리에 의존)
    //  "일정한 수준 까지는 스레드를 추가로 만들어 사용해서 성능상의 이점을 얻을 수 있지만
    //   특정 수준을 넘어간다면 성능이 떨어지게 된다
    //  "스레드 수에 제한을 두는 것이 중요하고 자원이 고갈되어 멈추는 상황이 발생하지 않도록
    //   제어해야 한다.
    /*
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };

            new Thread(task).start();
        }
    }
    */

    // Step 3. Pool-based Model
    // "순차적인 방법은 응답 속도와 전체적인 성능이 크게 떨어지는 문제점이 있고
    // 작업별로 스레드를 만들어 내는 방법은 자원 관리 측면에서 허점이 있다
    // 해결책
    // 1) 스레드 생성을 제한해야 한다.
    // 2) 생산자 & 소비자 모델
    // => 직접 구현해도 되지만, Executor 프레임워크를 사용하면 쉽게 적용 가능하다.

    public static final int NTRHEADS = 100;
    public static final Executor exec = Executors.newFixedThreadPool(100);
    // 장점 : 다양한 스레드 풀 정책이 의미 정의되어 있다
    // newFixedThreadPool  : 작업이 등록되면, 제한된 개수까지 스레드를 생성한다.
    //                      생성 이후에 더 이상 생성하지 않고 스레드 수를 유지한다.
    // newCachedThreadPool : 스레드 수가 처리할 작업보다 많아서 쉬는 스레드가 발생하면
    //                       스레드를 종료한다.
    // newSingleThreadPool : 단일 스레드로 처리된다. 등록된 작업은 설정된 큐에서 지정하는 순서에 의해
    //                       실행한다(LIFO, FIFO, 우선순위)

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };

            exec.execute(task);
        }
    }

}

















