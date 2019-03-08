package Cocktails;

public class BananaMilkCocktailMaker extends CocktailMaker{
    @Override
    public String liquid() {
        return "Молоко";
    }

    @Override
    public String mainIngredient() {
        return "Банан";
    }

    @Override
    public String toping() {
        return "Мороженное";
    }
}