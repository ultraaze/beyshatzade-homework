public class Main {

    static String file_address = "d:/result1.txt";

    public static void main(String[] args) {

        while (true) {

            try {
                Writer Rafa = new Writer(file_address);
                Rafa.start();
                Rafa.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Reader Rafa1 = new Reader(file_address);
                Rafa1.start();
                Rafa1.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}