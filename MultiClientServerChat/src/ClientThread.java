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
    TrippleDes crypt;

    {
        try {
            crypt = new TrippleDes();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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
        System.out.print("What is your name? ");
        try {
            name = inputUser.readLine();
            out.write(Caesar.encode(name) + "\n");
            //   out.write( name + "\n");
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
                    String temp = Caesar.decode(str);
                    //  String temp = str;
                    System.out.println(temp);
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
                    String text = "(" + timeNow + ") " + name + ": " + userWord;
                    out.write(Caesar.encode(text) + "\n");
                    //  out.write(text + "\n");
                    out.flush();
                } catch (IOException e) {

                    ClientThread.this.downService();
                }
            }
        }
    }
}