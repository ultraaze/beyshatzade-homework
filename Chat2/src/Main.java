public class Main {

    static String file_address = "d:/result1.txt";

    public static void main(String[] args) {
        while (true) {
            try {
                Writer writer = new Writer(file_address);
                writer.start();
                writer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Reader reader = new Reader(file_address);
                reader.start();
                reader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}