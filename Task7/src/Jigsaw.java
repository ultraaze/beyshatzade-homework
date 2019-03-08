public class Jigsaw extends Powertool {

    private double Thickness;

    public Jigsaw(int Cost, String Name, int Quantity, int Power, double Thickness) {
        super(Cost, Name, Quantity, Power);
        this.Thickness = Thickness;
         }

    public double getThickness() {
        return Thickness;
    }

    public void setThickness(double thickness) {
        Thickness = thickness;
    }

    @Override
    public String toString() {
        return "Лобзик "+ getName()+ " " + getCost() + " " + getQuantity()+ " мощность " + getPower()
                + " диаметр сверлa " + getThickness();
    }
}
