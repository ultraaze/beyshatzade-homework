public class Main {

    public static void main(String[] args) {

        int a=Integer.valueOf(args[0]);
        int b=Integer.valueOf (args[1]);

        if ((a<0)||(b<0))  System.out.println("Есть  отрицательное число");
        if (b!=0) System.out.println("Результат деления " + (float)a/b);
        if (a>b) System.out.println("a>b");
        else if (a<b) System.out.println("a<b");
        else System.out.println("a=b");
        if((a%2)==0) System.out.println("Число а четное");


    }
}
