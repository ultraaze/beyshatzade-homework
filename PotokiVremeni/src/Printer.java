import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Printer extends Thread {
    private int i;
    BufferedWriter writer = null;
    String names;
    ThreadGroup group;

    Printer(ThreadGroup group, int i) {
        this.group = group;
        this.i = i;
        names = i + ".txt";
    }

    @Override
    public void run() {
        try {
            writer = new BufferedWriter(new FileWriter("d:/strings_parallel/" + names));
            writer.write(Main.list.get(i));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}