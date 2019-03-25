import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientThread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String ip;
    private int port;
    private String name;
    private Date dateNow;
    private String timeNow;
    private SimpleDateFormat formatForDateNow;

    public ClientThread(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.setName();
            new Receiver().start();
            new Sender().start();
        } catch (IOException e) {
            ClientThread.this.downService();
        }
    }

    private void setName() {
        System.out.print("Press your name: ");
        try {
            name = inputUser.readLine();
            out.write((CaesarСipher.encode("Hello " + name, 12)) + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

    private class Receiver extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine();
                    String aaa = CaesarСipher.decode(str, 12);
                    if (str.equals("stop")) {
                        ClientThread.this.downService();
                        break;
                    }
                    System.out.println(aaa);
                }
            } catch (IOException e) {
                ClientThread.this.downService();
            }
        }
    }

    public class Sender extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    dateNow = new Date();
                    formatForDateNow = new SimpleDateFormat("HH:mm");
                    timeNow = formatForDateNow.format(dateNow);
                    userWord = inputUser.readLine();
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        ClientThread.this.downService();
                        break;
                    } else {
                        String text = "(" + timeNow + ") " + name + ": " + userWord;
                        out.write((CaesarСipher.encode(text, 12)) + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    ClientThread.this.downService();
                }
            }
        }
    }
}