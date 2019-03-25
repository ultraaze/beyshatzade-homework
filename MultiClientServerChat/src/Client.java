public class Client {

    public static String ip = "localhost";
    public static int port = 8080;

    public static void main(String[] args) {
        try {
            new ClientThread(ip, port);
        } catch (NullPointerException e) {
            System.err.println("Error connected to server");
        }
    }
}