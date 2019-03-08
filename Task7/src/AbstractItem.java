public abstract class AbstractItem implements Item{
    private int Cost;
    private String Name;
    private int Quantity;

    public AbstractItem (int Cost, String Name, int Quantity){
        this.Cost = Cost;
        this.Name = Name;
        this.Quantity = Quantity;
    }

    @Override
    public int getCost(){
        return this.Cost;
    }


    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public int getQuantity() {
        return this.Quantity;
    }


   }
