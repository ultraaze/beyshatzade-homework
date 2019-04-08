import java.io.*;
import java.net.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    public static final int port = 8080;
    public static List<ServerThread> serverList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started");
        HistoryWriter printer1 = new HistoryWriter("\r\nSTARTED A DIALOGUE");
        Thread thread1 = new Thread(printer1);
        thread1.start();
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}