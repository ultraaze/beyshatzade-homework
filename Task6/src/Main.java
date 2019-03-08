import Cocktails.*;

public class Main {

    public static void main(String[] args) {

        CocktailMaker[] Machines = new CocktailMaker[]{new BananaMilkCocktailMaker(),
                new StrawberryLemonCocktailMaker(), new KiwiLimeCocktailMaker()};

      for (int i= 0; i<Machines.length; i++)
          Machines[i].mix();
    }
}