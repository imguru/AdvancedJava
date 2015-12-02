import java.io.IOException;
import java.nio.file.*;

class Example7 {
    public static final String TARGET_PATH = "/Users/ourguide/Downloads/";

    public static void main(String[] args) throws IOException, InterruptedException {

        Path target = Paths.get(TARGET_PATH);

        try (WatchService fsWatchService = FileSystems.getDefault().newWatchService()) {

            target.register(fsWatchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                WatchKey key = fsWatchService.take();
                for (WatchEvent event : key.pollEvents()) {
                    System.out.printf("Received %s event for file: %s\n",
                            event.kind(), event.context());
                }
                boolean isReset = key.reset();
                if (!isReset)
                    break;
            }

        }
    }
}
