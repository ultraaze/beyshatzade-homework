import Enums.*;

public class Main {
    public static void main(String[] args) {

      Person[] Array = new Person[]{
              new Artist(Namelist.getRandom(), Surnamelist.getRandom(), Stylelist.getRandom()),
              new Musician(Namelist.getRandom(), Surnamelist.getRandom(), Instrumentlist.getRandom())};

      for (Object i:Array) {
          if (i instanceof Artist)
          System.out.println("<" + ((Artist) i).getName() + "><" + ((Artist) i).getSurname() +
                  "> рисует в стиле <"  +  ((Artist) i).getStyle() + ">");
       else {
           System.out.println("<" + ((Musician) i).getName() + "><" + ((Musician) i).getSurname() +
                   "> играет на <"  +  ((Musician) i).getInstrument() + ">");
       }
      }
    }
}