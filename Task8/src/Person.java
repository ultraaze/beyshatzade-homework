public abstract class Person {

    private String Name;

    public abstract int getAction();

    static private int Point = 0;

    private String[] Names = new String[]{"Ivan", "Evgeniy", "Anton", "Alex", "Petr", "Vova"};

    public Person() {
        if (Point > 5) {
            System.out.println("Имена начнут повторяться! (играющих>5");
            Point = 0;
        }
        this.Name = Names[Point];
        Point++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
