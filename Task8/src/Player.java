public class Player extends Person{
    private final int a = 0;   //  0 - не спрятался, 1 - спрятался
    private final int b =3;    //  2 - ушел домой
    private int Sostoyanie;

    public Player(){
        super();
        int random_number = a + (int) (Math.random() * b);
        this.Sostoyanie = random_number;
    }

    @Override
    public int getAction() {
        return Sostoyanie;
    }

    @Override
    public String toString() {
        return getName();
    }
}
