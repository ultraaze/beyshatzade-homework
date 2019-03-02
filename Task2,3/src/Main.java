import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int Arr[] = new int [args.length];
        for (int i= 0; i<args.length; i++){
            Arr[i] = Integer.valueOf(args [i]);
        }
        System.out.println("Введенный массив:");
        System.out.println(Arrays.toString(Arr));

        int Sum=0;
        for (int j: Arr){
            Sum+=j;
        }
        System.out.println("Сумма элементов массива = " + Sum);
        for (int z: Arr) {
            if (z>1000){
                System.out.println("Массив - массивный");
                break;
            }
        }
// Здесь начинается 3 задача
        int Max = Arr[0];
        for (int x: Arr) {
            if (x == 100500)
                continue;
            else if (Max<x)
                Max = x;
        }

        System.out.println("Наибольшее число массива = " + Max);
    }
}
