import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader extends Thread {
    BufferedReader reader = null;
    private String file_address;
    private String line;

    Reader(String file_address) {
        this.file_address = file_address;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new FileReader(file_address));
            line = reader.readLine();
            System.out.println(line.toUpperCase().replace('!', '.').replace('?', '.').replace(" ", ""));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
