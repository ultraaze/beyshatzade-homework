public class Master extends Person {
    private final int a = 0;   // 0 - "Не прячешься!"
    private final int b = 2;   // 1 - "Прячешься!"
    private int Said;

    public Master() {
        super();
        int random_number = a + (int) (Math.random() * b);
        this.Said = random_number;
    }

    @Override
    public int getAction() {
        return Said;
    }

    @Override
    public String toString() {
        return getName();
    }
}
