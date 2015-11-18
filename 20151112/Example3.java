package kr.co.ioacademy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// C99, C11(thread) - Android M
// C++11/14
// Java 8, 9

public class Example3 {
    /*
  private static void handleRequest(Socket connection) {
      OutputStream os = null;
      try {
          os = connection.getOutputStream();
          os.write("Hello World".getBytes());
          os.flush();
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (os != null)
              try {
                  os.close();
              } catch (IOException e) {

              }
      }
  }
  */

    // Try with Resource : Java 7 - (C# using block)
    // 1. Connection, Socket, Stream 비 메모리 자원을 해지하는
    //   명시적인 종료 메소드를 호출해야 하는 것은 코드를 어지럽힌다.
    // 2. try 블록에 존재하는 자원을 자동으로 회수해준다.
    // 3. AutoCloseable Interface
    private static void handleRequest(Socket connection) {
        try (OutputStream os = connection.getOutputStream();
             InputStream is = connection.getInputStream()) {
            os.write("Hello World".getBytes());
            os.flush();
        } catch (IOException e) {
        }
    }

    /*
    // Step 1. Single Thread Model
    // 1) 한번에 하나의 요청을 처리하는 것이 가능하다.
    // 2) 단일 스레드에서 IO 작업 등으로 대기하는 경우, 하드웨어 자원을
    //    효과적으로 사용할 수 없다.
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);

        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }
    */

    /*
    // Step 2. Thread per Connection Model
    // 순차적인 실행 방법보다 훨씬 더 많은 작업을 수행하는 것이 가능하다.

    // 문제점
    // 1. 엄청나게 많은 스레드가 생성된다.
    // 2. Thread 를 만들고 제거하는 작업에도 자원이 소모된다.
    // : 클라이언트의 요청이 작은 단위로 일어나는 경우에는 더욱더 문제가 심하다.
    // 3. 자원 낭비가 심하다.
    //  1) 실행 중인 스레드는 메모리를 많이 소모한다.
    //     Java의 스택은 두 개이다.(Java, Native)
    //  2) 프로세서의 개수 보다 많은 스레드가 생성되면 대부분의 스레드는
    //     대기 상태에 있다.
    // 4. 컨텍스트 스위칭의 비용이 크다.
    // 5. OS 에서 생성할 수 있는 스레드의 개수는 제한되어 있다.
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
    // 순차적으로 문제를 해결하는 방법은 응답 속도와 전체적인 성능이 떨어지는
    // 문제점이 있고 작업별로 스레드를 만들어 내는 방법은 자원 관리 측면에서
    // 문제점이 있다

    // 해결책)
    // 1) 스레드의 생성을 제한해야 한다 -> Thread pool
    // 2) 생산자 & 소비자 모델

    public static final int NTHREADS = 100;
    public static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
    // 1) newFixedThreadPool
    // 작업이 등록되면 제한된 개수까지 스레드를 생성해서 해당 작업을 처리한다.
    // 생성 이후에 더 이상 생성하지 않고 스레드 수를 유지한다.

    // 2) newCachedThreadPool
    // 스레드 수가 처리할 작업보다 많아서 쉬는 스레드가 발생하면,
    // 스레드를 종료한다.

    // 3) newSingleThreadPool
    // 단일 스레드로 처리한다. 등록된 작업은 다양한 정책에 의해서 수행될 수 있다.
    // (LIFO, FIFO, 우선순위)
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);

        while (true) {
            Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };

            exec.execute(task);
        }

    }
    // http://d.pr/n/17yBv
}















