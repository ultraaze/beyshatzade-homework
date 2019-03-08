package Enums;
import java.util.Random;

public enum Namelist {
    Ivan,
    Evgeniy,
    Anton,
    Alex,
    Petr;

    private static final Namelist[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    public static Namelist getRandomName()  {
        return Namelist.VALUES[RANDOM.nextInt(SIZE)];
    }
    public static String getRandom()  {
        return Namelist.getRandomName().toString();
    }
}
