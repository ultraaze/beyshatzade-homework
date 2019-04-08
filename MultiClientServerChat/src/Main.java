import java.io.IOException;

public class Main {
   static TrippleDes crypt1;
    {
        try {
            crypt1 = new TrippleDes();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {

        String text = "hi -";

        int index1 = text.indexOf('-'); // 2

        String substr1 = text.substring(index1); // ник

        String substr2 = text.substring(0,index1); //lo

        System.out.println(index1);
        System.out.println(text.length());

//        System.out.println(index1+1);
//        System.out.println(text.length());
        int a = index1+2;
        int b = text.length();
      if(5==5){
          System.out.println(substr1);
          System.out.println(substr2);
      }else
          System.out.println("низ");

//
//        System.out.println(index1+1);
//        System.out.println(text.length());
//        System.out.println(substr1);
//        System.out.println(substr2);


//        while (true) {
//            if(true){
//
//                return;
//            }
//
//
//            if (true){
//                System.out.println("ffd");
//            }
//        }





    }
}
