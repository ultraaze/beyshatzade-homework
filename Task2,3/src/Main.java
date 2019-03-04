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
        boolean Check = true;
        int Max = Arr[0];

        for (int z: Arr) {
            Sum+=z;
            if ((z>1000)&&(Check)){
                System.out.println("Массив - массивный");
                Check = false;
            }
            if (z == 100500)
                continue;
            else if ((Max<z)||(Max==100500))
                Max = z;
        }

        System.out.println("Сумма элементов массива = " + Sum);
        System.out.println("Наибольшее число массива = " + Max);

    }
}
