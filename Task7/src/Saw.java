public class Saw extends Powertool implements Returnable {

    private double Radius;
    private String RequiredDocuments;
    private int DaysForReturn;

    public Saw(int Cost, String Name, int Quantity, int Power, double Radius, String RequiredDocuments,
               int DaysForReturn) {
        super(Cost, Name, Quantity, Power);
        this.Radius = Radius;
        this.RequiredDocuments= RequiredDocuments;
        this.DaysForReturn= DaysForReturn;

    }

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double radius) {
        Radius = radius;
    }

    @Override
    public String getRequiredDocuments() {
        return this.RequiredDocuments;
    }

    @Override
    public int getDaysForReturn() {
        return this.DaysForReturn;
    }

    @Override
    public String toString() {
        return "Пилa дисковая "+ getName()+ " " + getCost() + " " + getQuantity()+ " мощность " + getPower()
                + " радиус дискa " + getRadius();
    }
}
