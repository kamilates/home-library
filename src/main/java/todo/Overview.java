package todo;

public class Overview {

    private static String zmienna = "ASUS";

//    public static void main(String[] args) {
//        for (int indeks = 0; indeks < 5; indeks++) {
//
//            if (indeks <= 2) {
//               continue;
//            }
//            System.out.println(indeks);
//            System.out.println(zmienna);
//        }
//
//    }


    public static void main(String[] args) {
        Car car = new Car(new Engine(), new Engine());
        car.wroom();
    }
}
