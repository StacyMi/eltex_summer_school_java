import Product.*;
import WorkWithOrders.*;

import java.util.Scanner;

public class Main {



    private static final int OBJECT = 5;
    static Clothes[] mass = new Clothes[OBJECT];
    static final Orders<Order> orders = new Orders<>();

    public static void main(String[] args) {

        String[] capsORt_shorts = {"caps", "t_shorts"};
        int capsORt_shortsInd;
        String caps = "caps";
        String t_shorts = "t_shorts";



        System.out.println("______________________________________________");
        System.out.println("№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n");

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
            mass[i].read();
            //mass[i].update();
            //mass[i].read();
        }
        System.out.println("______________________________________________");



        for (int i = 0; i < 3; i++) {
            System.out.println("******************************************************");
            AutoGeneratOrders obj = new AutoGeneratOrders();
            Thread threadOrder = new Thread(obj); //создание потока
            threadOrder.setName("Поток:" + i);
            threadOrder.start();
            try {
                threadOrder.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        int flagOut = 0;
        while (flagOut != 1) {
            Scanner sc = new Scanner(System.in);

            System.out.println("\t1\t-\tОбновить статусы");
            System.out.println("\t2\t-\tУдалить со статусом ОБРАБОТАН");
            System.out.println("\t3\t-\tЗавершить работу");
            int readNumber = sc.nextInt();

            if(readNumber >= 1 && readNumber <= 3 ) {
                if (readNumber == 1) {

                    Thread threadUpdateWait = new Thread(new ACheckWait( orders ));
                    try {
                        threadUpdateWait.sleep(1000);
                        threadUpdateWait.start();
                        threadUpdateWait.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    if (readNumber == 2) {
                        Thread threadUpdateProcessed = new Thread( new ACheckProcessed( orders ) );
                        try {
                            threadUpdateProcessed.sleep(100);
                            threadUpdateProcessed.start();
                            threadUpdateProcessed.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        flagOut = 1;

                    }
                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
            }
        }

    }

}
