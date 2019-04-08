public class Caesar {

    static private final int offset = 12;
    static private int offset1 = 0;

    public static void main(String args[]) {

        String line = encode("you left personal chat with");
        System.out.println(line);
        System.out.println(decode(line));
    }

    public static String decode(String enc) {

        return encode1(enc, 26 - offset);
    }

    public static String encode(String enc) {
        offset1 = (offset) % 26 + 26;
        StringBuilder encoded = new StringBuilder();

        for (char i : enc.toCharArray()) {

            if (Character.isLetter(i)) {

                if (((i >= 'a') && (i <= 'z')) || ((i >= 'A') && (i <= 'Z'))) {

                    if (Character.isUpperCase(i)) {

                        encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                    } else {
                        encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                    }
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static String encode1(String enc, int offset) {
        offset1 = (offset) % 26 + 26;
        StringBuilder encoded = new StringBuilder();

        for (char i : enc.toCharArray()) {

            if (Character.isLetter(i)) {

                if (((i >= 'a') && (i <= 'z')) || ((i >= 'A') && (i <= 'Z'))) {

                    if (Character.isUpperCase(i)) {

                        encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                    } else {
                        encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                    }
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}