public class Laptop extends Computer implements Returnable{
      private double Diagonal;
    private double Battery_time;
    private String RequiredDocuments;
    private int DaysForReturn;

    public Laptop(int Cost, String Name, int Quantity, int Memory, int Cpu_core, double Diagonal,
                  double Battery_time, String RequiredDocuments, int DaysForReturn ) {
        super(Cost, Name, Quantity, Memory, Cpu_core);
        this.Diagonal= Diagonal;
        this.Battery_time= Battery_time;
        this.RequiredDocuments= RequiredDocuments;
        this.DaysForReturn= DaysForReturn;
    }

    public double getDiagonal() {
        return Diagonal;
    }

    public void setDiagonal(double diagonal) {
        Diagonal = diagonal;
    }

    public double getBattery_time() {
        return Battery_time;
    }

    public void setBattery_time(double battery_time) {
        Battery_time = battery_time;
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
        return "Ноутбук "+ getName()+ " " + getCost() + " " + getQuantity()+ " число ядер " + getCpu_core() + " память "
                + getMemory() + " шт диагональ " + getBattery_time() + " время работы от батареи " + getDiagonal();
    }
}
