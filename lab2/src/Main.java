import java.util.Scanner;

public class Main {

    public static final int OBJECT = 5;

    public static void main(String[] args) {

        //System.out.println("3 вариант! [Входные данные: t_shorts или caps]");
        String[] capsORt_shorts = {"caps", "t_shorts"};
        int capsORt_shortsInd;
        String caps = "caps";
        String t_shorts = "t_shorts";
        Clothes[] mass = new Clothes[OBJECT];

        System.out.println("№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n");
        for (int i = 0; i < OBJECT; i++) {
            capsORt_shortsInd = 0 + (int)(Math.random() * capsORt_shorts.length);
            String view = capsORt_shorts[capsORt_shortsInd];
            if (view.equals(t_shorts) || view.equals(caps)) {
                if (view.equals(t_shorts)) {
                    mass[i] = new T_shorts();
                }
                if (view.equals(caps)) {
                    mass[i] = new Caps();
                }
            }
            mass[i].create();
            mass[i].update();
            mass[i].read();
        }
        /*
        System.out.println("\nВариант 3\n" +
                "Коллекция для хранения объектов в классе «корзина»: ArrayList\n" +
                "Коллекция для хранения объектов в классе «заказы»: LinkedList\n" +
                "Коллекция для хранения и поиска уникальных идентификаторов: TreeSet\n" +
                "Коллекция для хранения объектов по времени создания: HashMap");
*/
        System.out.println("\nРегистрация пользователя");
        Credentials user1 = new Credentials();
        user1.addUser();
        user1.printUser();
        user1.editUser();
/*
        int flag = 0;
        while (flag != 1) {
            int readNumber;
            System.out.println("\t1\t-\tСоздать заказ");
            System.out.println("\t2\t-\tЗавершить работу!");
            Scanner sc = new Scanner(System.in);

            System.out.print("\nВаш выбор:\t");
            readNumber = sc.nextInt();
            if (readNumber >= 1 && readNumber <= 2) {
                if (readNumber == 1) {

                   */
                    System.out.println("\nДобавление элементов в корзину");
                    ShoppingCart basket = new ShoppingCart();
                    basket.editClothes(mass, user1);
         /*       }
                if (readNumber == 2) {
                    flag = 1;
                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
                //System.exit(0);
            }

        }
*/




    }

}
