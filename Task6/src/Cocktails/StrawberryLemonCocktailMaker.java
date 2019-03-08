package Cocktails;

public class StrawberryLemonCocktailMaker extends CocktailMaker{
    @Override
    public String liquid() {
        return "Вода";
    }

    @Override
    public String mainIngredient() {
        return "Клубника";
    }

    @Override
    public String toping() {
        return "Лимон";
    }
}