package Enums;
import java.util.Random;

public enum Stylelist {
    Woodcutting,
    Lithography,
    Pen_and_Ink,
    Advertising;

    private static final Stylelist[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    public static Stylelist getRandomStyle(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }
    public static String getRandom()  {
        return Stylelist.getRandomStyle().toString();
    }
}
