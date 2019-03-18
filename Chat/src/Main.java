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
        String file_address = "d:/result.txt";
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file_address));
            System.out.println("Сохраненные переписки:");
            String line;
            do {
                line = reader.readLine();
                System.out.println(line);
            }
            while (line != null);

        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Проблемы с закрытием файла");
            }
        }

        try {

            writer = new BufferedWriter(new FileWriter(file_address, true));
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
                    String name1 = message.toUpperCase().replace('!', '.').replace('?', '.').replace(" ", "");
                    Date dateNow = new Date();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("H:m");
                    System.out.println("Бот: " + name1 + bot_phrase);
                    writer.write(formatForDateNow.format(dateNow) + " Бот: " + name1 + bot_phrase + "\r\n");
                    bot_phrase = "";
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Проблемы с закрытием файла");
            }
        }
    }
}