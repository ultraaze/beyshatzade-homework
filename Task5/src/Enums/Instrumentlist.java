package Enums;
import java.util.Random;

public enum Instrumentlist {
    Accordion,
    Balalaika,
    Organ,
    Violin;

    private static final Instrumentlist[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    public static Instrumentlist getRandomInstrument()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
    public static String getRandom()  {
        return Instrumentlist.getRandomInstrument().toString();
    }
}
