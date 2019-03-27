import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader extends Thread {
    private File file;
    private BufferedReader reader;
    String line;
    ThreadGroup group;

    Reader(ThreadGroup group, File f) {
        this.file = f;
        this.group = group;
    }

    public synchronized void Method() {
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            Main.stringsParallel.add(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Method();
    }
}
