package Cocktails;

public abstract class CocktailMaker {

        public void mix(){
            liquid();
            mainIngredient();
            toping();
            System.out.println("Смешиваю " + liquid()+ " с " + mainIngredient() + " и добавляю сверху " + toping());
        }

        public abstract String liquid();
        public abstract String mainIngredient();
        public abstract String toping();
}