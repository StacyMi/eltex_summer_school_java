import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class ShoppingCart {

    public static int count;

    public ArrayList <String> list = new ArrayList<>();

    public void add(String idClothe, Clothes[] mass) {
            UUID listID = UUID.fromString(idClothe);
            int flag = 0;
            for (int i = 0; i < mass.length; i++) {
                //System.out.println("add--->" + mass[i].id);
                //System.out.println("add--->" + listID + "\n");
                if (mass[i].id.equals(listID)) {
                    list.add(idClothe);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Товара с таким ID нет!");
            }
    }

    public void delete(String idClothe) {
        list.remove(idClothe);
    }
    public void deleteAll() {
        for (int j = 0; j < list.size(); j++ ) {
            list.remove(j);
        }
    }

    public void print(Clothes[] mass){
        System.out.println("______________________________________________");
        System.out.println("В корзине:\n");
        for (int index = 0; index < list.size(); index++) {
            UUID listID = UUID.fromString(list.get(index));
            for (int i = 0; i < mass.length; i++) {
                if (mass[i].id.equals(listID)) {
                    mass[i].readBasket();
                }
            }
        }
        System.out.println("______________________________________________");
    }

    public void editClothes(Clothes[] mass, Credentials user1) {
        int ind;
        String indClothe;
        int flag = 0;
        while (flag != 1) {
            System.out.println("\t1\t-\tДобавить в карзину");
            System.out.println("\t2\t-\tУдалить из корзины");
            System.out.println("\t3\t-\tОформить заказ!");

            Scanner sc = new Scanner(System.in);
            System.out.print("\nВаш выбор:\t");
            ind = sc.nextInt();
            if (ind >= 1 && ind <= 3) {
                if (ind == 1) {
                    System.out.print("Индекс товара который добавить:\t");
                    indClothe = sc.next();
                    add(indClothe, mass);
                    print(mass);
                }
                if (ind == 2) {
                    System.out.print("Индекс товара который удалить:\t");
                    indClothe = sc.next();
                    delete(indClothe);
                    print(mass);
                }
                if (ind == 3) {
                    flag = 1;
                    Orders orders = new Orders();
                    orders.createOrder(list, mass, count);
                    count++;
                    orders.testOrders(count);
                    orders.print(user1, count);
                    deleteAll();

                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
            }
        }
    }
}
