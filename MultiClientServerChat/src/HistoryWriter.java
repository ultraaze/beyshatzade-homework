import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryWriter implements Runnable {
    private String name;
    private String file_address = "d:/result.txt";
    private BufferedWriter file;

    public HistoryWriter(String name) {
        this.name = name;
        try {
            file = new BufferedWriter(new FileWriter(file_address, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            file.write(name + "\r\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}