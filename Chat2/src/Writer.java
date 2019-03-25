import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer extends Thread {
    String message = " ";
    BufferedWriter writer = null;
    private String file_address;
    Scanner scanner;

    Writer(String file_address) {
        this.file_address = file_address;
    }

    @Override
    public void run() {

        scanner = new Scanner(System.in);
        message = scanner.nextLine();

        try {

            writer = new BufferedWriter(new FileWriter(file_address));
            writer.write(message + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
