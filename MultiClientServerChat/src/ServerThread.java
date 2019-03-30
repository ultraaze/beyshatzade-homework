import java.io.*;
import java.net.*;

class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private static int count = 0;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        count++;
        System.out.println("Сlient " + socket.getLocalSocketAddress() + " is connected. Total: " + count);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush();
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    word = in.readLine();
                    if (word.equals("stop")) {
                        this.downService();
                        break;
                    }
                    System.out.println("Came to server: " + word);
                    HistoryWriter printer1 = new HistoryWriter(word);
                    Thread thread1 = new Thread(printer1);
                    thread1.start();

                    for (ServerThread all : Server.serverList) {
                        if (all == this) continue;
                        all.out.write(word + "\n");
                        all.out.flush();
                    }
                }
            } catch (NullPointerException ignored) {
            }

        } catch (IOException e) {
            this.downService();
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                Server.serverList.removeIf(value -> value.equals(this));
                count--;
                System.out.println("Сlient " + socket.getLocalSocketAddress() + " is disconnected. Total: " + count);
            }
        } catch (IOException ignored) {
        }
    }
}