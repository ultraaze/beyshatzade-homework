package Cocktails;

public class KiwiLimeCocktailMaker extends CocktailMaker{
    @Override
    public String liquid() {
        return "Вода";
    }

    @Override
    public String mainIngredient() {
        return "Киви";
    }

    @Override
    public String toping() {
        return "Лайм";
    }
}