public abstract class Computer extends AbstractItem{

    private int Memory;
private int Cpu_core;


public Computer(int Cost, String Name, int Quantity, int Memory, int Cpu_core) {
    super(Cost, Name, Quantity);
    this.Memory = Memory;
    this.Cpu_core = Cpu_core;
}
    public int getMemory() {
        return Memory;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public int getCpu_core() {
        return Cpu_core;
    }

    public void setCpu_core(int cpu_core) {
        Cpu_core = cpu_core;
    }

}

