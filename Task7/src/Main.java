public class Main {

    public static void main(String[] args) {
        Laptop HP = new Laptop(1000, "HP", 5, 512, 8, 15.3, 12.3, "Чек+паспорт", 14);
        Laptop Apple = new Laptop(2000, "Apple", 8, 256, 4, 12, 11, "Чек+паспорт", 14);
        Desktop Depo = new Desktop(1500, "Depo", 2, 1012, 6);
        Desktop Samsumg = new Desktop(1900, "Samsumg", 8, 2048, 12);
        Jigsaw Bosch = new Jigsaw(500, "Bosch", 74, 700, 7.4);
        Jigsaw Metabo = new Jigsaw(900, "Metabo", 25, 200, 8.4);
        Saw AEG = new Saw(200, "AEG", 12, 300, 20, "чек+паспорт", 21);
        Saw Beko = new Saw(800, "Beko", 22, 500, 25, "чек+паспорт", 21);
        Drill Vihr = new Drill(600, "Вихрь", 11, 300, 36, "чек", 14);
        Drill Daewoo = new Drill(700, "Daewoo", 21, 400, 26, "чек", 14);

        AbstractItem[] Arr = new AbstractItem[]{HP, Apple, Depo, Samsumg, Bosch, Metabo, AEG, Beko, Vihr, Daewoo};

        int Sum,SumMemory,MaxPower;
        Sum = SumMemory = MaxPower = 0 ;

        System.out.println();
        for (int i = 0; i < Arr.length; i++) {
            System.out.println(Arr[i].toString());
            Sum+=Arr[i].getCost();
            if (Arr[i] instanceof Powertool) {
                if ((((Powertool) Arr[i]).getPower()) > MaxPower) {
                    MaxPower = ((Powertool) Arr[i]).getPower();
                }
            }
            if (Arr[i] instanceof Computer) {
                SumMemory+= ((Computer) Arr[i]).getMemory();
            }
        }
        System.out.println();
        System.out.println("Сумма, которую заработает магазин продав все товары: " + Sum);
        System.out.println("Инструмент с максимальной мощностью: " + MaxPower);
        System.out.println("Сумма места на жестком диске: " + SumMemory + "\n ");
        System.out.println("Все товары, которые можно вернуть: ");

        for (int i = 0; i < Arr.length; i++) {
            if ((Arr[i] instanceof Returnable)&&(Arr[i] instanceof Computer)) {
                System.out.println(Arr[i].toString() + " документы " + (((Laptop) Arr[i]).getRequiredDocuments()) +
                        " в течении " + (((Laptop) Arr[i]).getDaysForReturn()) + " дней");
            }
            else if ((Arr[i] instanceof Returnable)&&(Arr[i] instanceof Powertool)){
                if ((Arr[i] instanceof Drill)){
                System.out.println(Arr[i].toString() + " документы " + (((Drill) Arr[i]).getRequiredDocuments())+
                        " в течении "+(((Drill) Arr[i]).getDaysForReturn()) + " дней");
                }
                else if ((Arr[i] instanceof Saw)){
                System.out.println(Arr[i].toString() + " документы " + (((Saw) Arr[i]).getRequiredDocuments())+
                        " в течении "+(((Saw) Arr[i]).getDaysForReturn()) + " дней");
                }
            }
        }

    }
}