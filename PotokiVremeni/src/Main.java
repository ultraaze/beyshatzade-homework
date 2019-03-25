import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class Main {
    public static ArrayList<String> list = new ArrayList<String>();
    public static ArrayList<String> stringsSequential = new ArrayList<String>();
    public static ArrayList<String> stringsParallel = new ArrayList<String>();
    static int length = 1200;
    static boolean check1 = false;

    public static void main(String[] args) {

        BufferedWriter writer = null;
        BufferedReader reader = null;
        long start = 0;
        long finish = 0;

        for (int i = 0; i < length; i++) {
            list.add("Строка " + i);
        }

        start = System.currentTimeMillis();

        for (int i = 0; i < length; i++) {
            String names = i + ".txt";
            try {
                writer = new BufferedWriter(new FileWriter("d:/strings_sequential/" + names));
                writer.write(list.get(i));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finish = System.currentTimeMillis();
        System.out.println("Скорость выполнения последовательного = " + (finish - start) + " мс");

        ThreadGroup group = new ThreadGroup("Write");
        start = System.currentTimeMillis();


        for (int i = 0; i < length; i++) {
            new Printer(group, i).start();
        }
        while (group.activeCount() != 0) ;

        finish = System.currentTimeMillis();
        System.out.println("Скорость выполнения параллельного = " + (finish - start) + " мс");


        File file = new File("d:/strings_sequential/");
        File[] files = file.listFiles();

        String line;
        start = System.currentTimeMillis();
        for (File f : files) {
            try {
                reader = new BufferedReader(new FileReader(f));
                line = reader.readLine();
                stringsSequential.add(line);
                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        finish = System.currentTimeMillis();
        System.out.println("Скорость чтения последовательного = " + (finish - start) + " мс");


        ThreadGroup group1 = new ThreadGroup("Reader");
        start = System.currentTimeMillis();
        for (File f : files) {
            new Reader(group1, f).start();
        }

        while (group1.activeCount() != 0) ;
        finish = System.currentTimeMillis();

        System.out.println("Скорость чтения || = " + (finish - start) + " мс");
    }
}

