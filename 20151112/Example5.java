package kr.co.ioacademy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Example5 {
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
 
   public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }
 }

















