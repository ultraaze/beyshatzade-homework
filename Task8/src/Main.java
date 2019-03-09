import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList Winners = new ArrayList();
        ArrayList Losers = new ArrayList();
        ArrayList Fraud = new ArrayList();

        Person[] Gamers = new Person[]{new Master(), new Player(), new Player(),
                new Master(), new Player(), new Player()};

        try {
            for (int i = 1; i < 6; i++) {
                if (Gamers[0].getAction() == 0) {
                    if (Gamers[i].getAction() == 0)
                        Losers.add(Gamers[i]);
                    else if ((Gamers[i].getAction() == 1) || (Gamers[i].getAction() == 2))
                        Winners.add(Gamers[i]);
                } else {
                    if (Gamers[i].getAction() == 0)
                        Winners.add(Gamers[i]);
                    else if (Gamers[i].getAction() == 1)
                        Losers.add(Gamers[i]);
                    else {
                        Fraud.add(Gamers[i]);
                        throw new MiJeDogovarivalisDomaNePryatatsaException();
                    }
                }
            }

            String string = Winners.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("Winners: \n" + string);
            String string1 = Losers.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("\nLosers: \n" + string1);


        } catch (MiJeDogovarivalisDomaNePryatatsaException e) {
            String string = Fraud.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("<" + string + ">" + " играет нечестно");
        }

    }
}
