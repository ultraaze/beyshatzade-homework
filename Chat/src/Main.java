import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        String message = " ";
        boolean check = true;
        int i = 0;
        long start = 0;
        long finish = 0;
        String bot_phrase = "";

        try {

            BufferedReader reader = new BufferedReader(new FileReader("d:/result.txt"));
            System.out.println("Сохраненные переписки:");
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Проблемы со считываемым файлом");
        }

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("d:/result.txt", true));
            writer.write("Начало беседы" + "\r\n");
            System.out.println("Начало беседы (Чтобы завершить беседу и сохранить переписку отправь в консоль END)");

            while (check) {

                if ((i % 2) == 0) {
                    System.out.print("Пользователь: ");
                    Scanner scanner = new Scanner(System.in);
                    message = scanner.nextLine();

                    if ("END".equals(message)) {
                        check = false;
                        message = "Конец беседы" + "\r\n";
                        writer.write(message + "\r\n");
                    } else {
                        start = System.currentTimeMillis();
                        if (((start - finish) > 10800000) && (finish != 0)) {
                            bot_phrase = "чТОТОДАВНОТЕБЯНЕВИДНО";
                        }
                        Date dateNow = new Date();
                        SimpleDateFormat formatForDateNow = new SimpleDateFormat("H:m");
                        writer.write(formatForDateNow.format(dateNow) + " Пользователь: " + message + "\r\n");
                        i++;
                    }
                } else {
                    finish = start;
                    String name1 = message.toUpperCase();
                    String name2 = name1.replace('!', '.');
                    String name3 = name2.replace('?', '.');
                    Date dateNow = new Date();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("H:m");
                    System.out.println("Бот: " + name3 + bot_phrase);
                    writer.write(formatForDateNow.format(dateNow) + " Бот: " + name3 + bot_phrase + "\r\n");
                    bot_phrase = "";
                    i++;
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Проблемы с записью файла");
        }
    }
}