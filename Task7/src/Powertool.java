public abstract class Powertool extends AbstractItem{

        private int Power;
    public Powertool(int Cost, String Name, int Quantity, int Power) {
        super(Cost, Name, Quantity);
        this.Power = Power;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }
}
