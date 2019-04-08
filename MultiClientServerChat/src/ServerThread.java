import java.io.*;
import java.net.*;

class ServerThread extends Thread {
    private Socket socket;
    public BufferedReader in;
    public BufferedWriter out;
    private static int total = 0;

    public String nickname;


    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        total++;
        System.out.println("Сlient " + socket.getLocalSocketAddress() + " is connected. Total: " + total);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = in.readLine();
            this.nickname = word;
            String onlineusers = "";
            String substr3 = null;
            String substr4 = null;
            try {
                for (ServerThread online : Server.serverList) {
                    if (online == this) {
                        onlineusers += "[kag] ";    // you
                    } else {
                        onlineusers += "[" + online.nickname + "] ";
                        online.out.write("[" + word + "] vauzqp" + "\n");   // joined
                        online.out.flush();
                    }
                }

                out.write("Tu," + word + "\n");   //   hi
                out.flush();
                out.write("azxuzq: " + onlineusers + "\n");   // online
                out.flush();
            } catch (IOException ignored) {
            }
            try {
                boolean onlyforone = true;
                while (true) {
                    word = in.readLine();
                    System.out.println("Came to server: " + word);
                    HistoryWriter printer1 = new HistoryWriter(word);
                    Thread thread1 = new Thread(printer1);
                    thread1.start();

                    if ((word.contains("-")) & onlyforone) {
                        int index1 = word.indexOf('-');
                        String substr1 = word.substring(index1 + 1);
                        String substr2 = word.substring(0, index1); //сообщение

                        int count = 0;
                        for (ServerThread all : Server.serverList) {
                            count++;
                            if (all.nickname.equals(substr1)) {
                                all.out.write(substr2 + "\n");
                                all.out.flush();
                                break;
                            }
                            if (count == Server.serverList.size()) {
                                new Offline(substr1, substr2);
                            }
                        }

                    } else if (word.contains("+") || !onlyforone) {
                        if (word.contains("+") & onlyforone) {
                            onlyforone = false;
                            int index1 = word.indexOf('+');
                            substr3 = word.substring(index1 + 1);
                            substr4 = word.substring(0, index1); //сообщение
                            int count1 = 0;
                            boolean looop = true;
                            for (ServerThread all : Server.serverList) {
                                count1++;
                                if (all.nickname.equals(this.nickname)) {
                                    String temp2 = "bduhmfq otmf iuft [" + substr3 + "]";  //private chat with
                                    all.out.write(temp2 + "\n");
                                    all.out.flush();
                                }
                                if (all.nickname.equals(substr3)) {
                                    String temp = "[" + this.nickname + "] efmdfqp m bduhmfq otmf iuft kag";  //started a private chat with you
                                    all.out.write(temp + "\n");
                                    all.out.flush();
                                    looop = false;
                                }
                                if ((count1 == Server.serverList.size()) & looop) {
                                    new Offline(substr3, substr4);
                                }
                            }
                        } else {
                            int count1 = 0;
                            if (word.contains("EFAB")) {    //STOP
                                onlyforone = true;
                                for (ServerThread all : Server.serverList) {
                                    if (all.nickname.equals(this.nickname)) {
                                        String temp2 = "kag xqrf bqdeazmx otmf iuft [" + substr3 + "]";   //you left personal chat with
                                        all.out.write(temp2 + "\n");
                                        all.out.flush();
                                    }
                                    if (all.nickname.equals(substr3)) {
                                        String temp = "[" + this.nickname + "] xqrf bduhmfq otmf";  //left private chat
                                        all.out.write(temp + "\n");
                                        all.out.flush();
                                    }

                                }

                            } else {
                                for (ServerThread all : Server.serverList) {
                                    count1++;
                                    if (all.nickname.equals(substr3)) {
                                        all.out.write(word + "\n");
                                        all.out.flush();
                                        break;
                                    }
                                    if (count1 == Server.serverList.size()) {
                                        new Offline(substr3, word);
                                    }
                                }
                            }
                        }
                    } else {
                        for (ServerThread all : Server.serverList) {
                            if (all == this) {
                                all.out.write(word + " <eqzf fa mxx> " + "\n");  //sent to all
                                all.out.flush();
                                continue;
                            }
                            all.out.write(word + "\n");
                            all.out.flush();
                        }
                    }
                }
            } catch (NullPointerException ignored) {
            }

        } catch (IOException e) {
            try {
                for (ServerThread all : Server.serverList) {
                    if (all == this) continue;
                    all.out.write("[" + this.nickname + "] cguf" + "\n");  //quit
                    all.out.flush();
                }
            } catch (IOException ignore) {
            }
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
                total--;
                System.out.println("Сlient " + socket.getLocalSocketAddress() + " is disconnected. Total: " + total);
            }
        } catch (IOException ignored) {
        }
    }
}