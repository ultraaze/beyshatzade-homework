import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reader extends Thread {
    BufferedReader reader = null;
    private String file_address;
    private String line;
    long start = 0;
    long buffer = 0;
    static int i = 0;

    Reader(String file_address) {
        this.file_address = file_address;
    }

    @Override
    public void run() {
        try {
            start = System.currentTimeMillis();
            if ((i % 2) == 0) {
                buffer = start;
            }
            reader = new BufferedReader(new FileReader(file_address));
            line = reader.readLine();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("H:m");
            if ((start - buffer) > 10800000)
                System.out.println(formatForDateNow.format(dateNow) + " " + line.toUpperCase().replace('!', '.').replace('?', '.').replace(" ", "") + "чТОТОДАВНОТЕБЯНЕВИДНО");
            else
                System.out.println(formatForDateNow.format(dateNow) + " " + line.toUpperCase().replace('!', '.').replace('?', '.').replace(" ", ""));
            i++;
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
