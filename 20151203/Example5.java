import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

class Example5 {
    public final static String from = "/Users/ourguide/Dropbox/sample.jpg";
    public final static String to = "/Users/ourguide/Desktop/to.jpg";

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        copy(from, to);

        long entTime = System.nanoTime();
        long totalTime = (entTime - startTime) / 1000000L;
        System.out.println(totalTime + " ms");
    }

    
    public static void copy(String from, String to) throws IOException {
        try (InputStream is = new FileInputStream(from);
             OutputStream os = new FileOutputStream(to)) {
            while (true) {
                int data = is.read();
                if (data == -1) // EOF
                    break;

                os.write(data);
            }
        }
    }
}