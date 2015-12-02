import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class Example6 {
    public final static String from = "/Users/ourguide/Dropbox/sample.jpg";
    public final static String to = "/Users/ourguide/Desktop/to.jpg";

    public static void main(String[] args) throws InterruptedException, IOException {

        ByteBuffer buf = ByteBuffer.allocateDirect(4096);


        AsynchronousFileChannel fis = AsynchronousFileChannel.open(Paths.get(from));
        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {

            int pos = 0;
            FileChannel fos = FileChannel.open(Paths.get(to),
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

            @Override
            public void completed(Integer result, Object attachment) {

                System.out.println(result + "bytes read!");
                if (result == -1)
                    return;

                buf.flip();
                try {
                    fos.write(buf, pos);
                    pos += result;
                    buf.clear();
                    fis.read(buf, pos, null, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        };

        fis.read(buf, 0, null, handler);

        System.in.read();
    }
}