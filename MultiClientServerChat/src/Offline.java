import java.io.IOException;

public class Offline implements Runnable {
    private String name;
    private String name1;
    private boolean AMG = true;
    Thread thread;

    public Offline(String name, String name1) {
        this.name = name;
        this.name1 = name1;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void demoMethod() {
        while (AMG) {
            for (ServerThread all : Server.serverList) {
                try {
                    if (name.equals(all.nickname)) {
                        try {
                            all.out.write(name1 + "\n");
                            all.out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (NullPointerException ignore) {
                        } finally {
                            AMG = false;
                        }
                    }
                } catch (NullPointerException ignore) {
                }
            }
        }
    }

    public void run() {
        demoMethod();
    }
}