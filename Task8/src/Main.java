import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList winners = new ArrayList();
        ArrayList losers = new ArrayList();
        ArrayList fraud = new ArrayList();

        Person[] Gamers = new Person[]{new Master(), new Player(), new Player(),
                new Master(), new Player(), new Player()};

        try {
            for (int i = 1; i < 6; i++) {
                if (Gamers[0].getAction() == 0) {
                    if (Gamers[i].getAction() == 0)
                        losers.add(Gamers[i]);
                    else if ((Gamers[i].getAction() == 1) || (Gamers[i].getAction() == 2))
                        winners.add(Gamers[i]);
                } else {
                    if (Gamers[i].getAction() == 0)
                        winners.add(Gamers[i]);
                    else if (Gamers[i].getAction() == 1)
                        losers.add(Gamers[i]);
                    else {
                        fraud.add(Gamers[i]);
                        throw new MiJeDogovarivalisDomaNePryatatsaException();
                    }
                }
            }

            String string = winners.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("Winners: \n" + string);
            String string1 = losers.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("\nLosers: \n" + string1);


        } catch (MiJeDogovarivalisDomaNePryatatsaException e) {
            String string = fraud.toString()
                    .replace("[", "")
                    .replace("]", "");
            System.out.println("<" + string + ">" + " играет нечестно");
        }
    }
}
