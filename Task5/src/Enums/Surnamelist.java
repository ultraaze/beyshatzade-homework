package Enums;
import java.util.Random;

public enum Surnamelist {
    Ivanov,
    Petrov,
    Sidorov,
    Avakov,
    Medvedev;

    private static final Surnamelist[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    public static Surnamelist getRandomSurname()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
    public static String getRandom()  {
        return Surnamelist.getRandomSurname().toString();
    }
}
