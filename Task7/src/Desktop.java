public class Desktop extends Computer {
    public Desktop(int Cost, String Name, int Quantity, int Memory, int Cpu_core) {
        super(Cost, Name, Quantity, Memory, Cpu_core);
    }

    @Override
    public String toString() {
        return "Моноблок "+getName()+ " "+ getCost() + " "+ getQuantity()+ " число ядер "+getCpu_core()+" память "
                + getMemory() + " Гб";
    }
}
