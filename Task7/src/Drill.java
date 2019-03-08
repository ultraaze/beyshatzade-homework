public class Drill extends Powertool implements Returnable{

    private float Diameter;
    private String RequiredDocuments;
    private int DaysForReturn;

    public Drill(int Cost, String Name, int Quantity, int Power, float Diameter, String RequiredDocuments,
                 int DaysForReturn) {
        super(Cost, Name, Quantity, Power);
        this.Diameter = Diameter;
        this.RequiredDocuments= RequiredDocuments;
        this.DaysForReturn= DaysForReturn;

    }

    public float getDiameter() {
        return Diameter;
    }

    public void setDiameter(float diameter) {
        Diameter = diameter;
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
        return "Дрель "+ getName()+ " " + getCost() + " " + getQuantity()+ " мощность " + getPower()
                + " диаметр сверла " + getDiameter();
    }
}
