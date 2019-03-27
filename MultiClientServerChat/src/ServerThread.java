import java.io.*;
import java.net.*;

class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
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

                    for (ServerThread vr : Server.serverList) {
                        if (vr == this) continue;
                        vr.out.write(word + "\n");
                        vr.out.flush();
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
                for (ServerThread vr : Server.serverList) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }
}
