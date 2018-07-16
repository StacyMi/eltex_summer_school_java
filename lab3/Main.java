import Product.*;

import java.util.Scanner;

public class Main {

    private static final int OBJECT = 5;
    static Clothes[] mass = new Clothes[OBJECT];


    public static void main(String[] args) {

        //System.out.println("3 вариант! [Входные данные: t_shorts или caps]");


        String[] capsORt_shorts = {"caps", "t_shorts"};
        int capsORt_shortsInd;
        String caps = "caps";
        String t_shorts = "t_shorts";



        for (int i = 0; i < OBJECT; i++) {
            capsORt_shortsInd = (int)(Math.random() * capsORt_shorts.length);
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
            //mass[i].update();
            //mass[i].read();
        }

        Orders<Order> listOrders = new Orders<>();

        int flag = 0;
        while (flag != 1) {
            System.out.println("______________________________________________");
            System.out.println("\t1\t-\tСоздать новый заказ");
            System.out.println("\t2\t-\tЗавершить работу!");
            Scanner sc = new Scanner(System.in);

            System.out.print("\nВаш выбор:\t");
            int readNumber = sc.nextInt();
            if (readNumber >= 1 && readNumber <= 2) {
                if (readNumber == 1) {
                    Clothes.number = 0;
                    System.out.println("______________________________________________");
                    System.out.println("№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n");
                    for (int i = 0; i < OBJECT; i++) {
                        mass[i].read();
                    }
                    Clothes.number = 0;



                    System.out.println("______________________________________________");
                    int countClotheInBasket = 0;

                    //System.out.println("\nДобавление элементов в корзину");

                    ShoppingCart<Clothes> basket = new ShoppingCart<>();
                    System.out.print("\nID товара, который добавить:\t");
                    String idClothe = sc.next();
                    int i;
                    int rezult = 0;
                    for (i = 0; i < mass.length; i++) {
                        String massID = mass[i].id.toString();
                        if (massID.equals(idClothe)) {
                            rezult = basket.add(mass[i]);
                        }
                    }

                    if (rezult == 1) {
                        countClotheInBasket++;
                    } else {
                        System.out.println("Товара с таким ID нет!");
                    }
                    int flagOut = 0;
                    while (flagOut != 1) {
                        basket.print();
                        System.out.println("\t1\t-\tДобавить товар");
                        System.out.println("\t2\t-\tУдалить товар");
                        System.out.println("\t3\t-\tОформить заказ");

                        System.out.print("\nВаш выбор:\t");
                        int readSelect = sc.nextInt();
                        if (readSelect >= 1 && readSelect <=3) {
                            if(readSelect == 1){
                                System.out.print("\nID товара, который добавить:\t");
                                idClothe = sc.next();
                                rezult = 0;
                                for (i = 0; i < mass.length; i++) {
                                    String massID = mass[i].id.toString();
                                    if (massID.equals(idClothe)) {
                                        rezult = basket.add(mass[i]);
                                    }
                                }
                                if (rezult == 1) {
                                    countClotheInBasket++;
                                } else {
                                    System.out.println("Товара с таким ID нет!");
                                }
                            } else {
                                if (readSelect == 2) {
                                    if (countClotheInBasket >= 1) {
                                        System.out.print("\nID товара, который удалить:\t");
                                        idClothe = sc.next();
                                        rezult = 0;
                                        for (i = 0; i < mass.length; i++) {
                                            String massID = mass[i].id.toString();
                                            if (massID.equals(idClothe)) {
                                                rezult = basket.delete(mass[i]);
                                            }
                                        }
                                        if (rezult == 1) {
                                            countClotheInBasket--;
                                        }
                                    } else {
                                        System.out.println("Товаров нет в корзине!");
                                    }
                                } else {
                                    flagOut = 1;
                                }
                            }
                        }
                    }

                   // System.out.println("\nРегистрация пользователя:");

                    Credentials user1 = new Credentials();
                    user1.add();
                    int fl = 0;
                    while (fl != 1) {
                        System.out.println("\t1\t-\tИзменить данные пользователя");
                        System.out.println("\t2\t-\tПродолжить оформление заказа");

                        System.out.print("\nВаш выбор:\t");
                        int read = sc.nextInt();
                        if (read >= 1 && read <= 2) {
                            if (read == 1) {
                                user1.print();
                                user1.update();
                            } else {
                                user1.print();
                                fl = 1;
                            }
                        } else {
                            System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
                        }
                    }

                    //System.out.println("\nОформление заказа:");

                    listOrders.createBuy(basket, user1);




                }
                if (readNumber == 2) {
                    flag = 1;
                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
                //System.exit(0);
            }

        }
        System.out.println("\nВсе текущие заказы, время обработки которых не истекло:");
        listOrders.testStatusAndTime();
        listOrders.printAllOrders();
    }

}
