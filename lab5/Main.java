import Product.*;
import WorkWithOrders.*;
import WorkWithThreads.*;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static final int OBJECT = 5;
    private static Clothes[] mass = new Clothes[OBJECT];
    public static final Orders<Order> orders = new Orders<>();

    public static void main(String[] args) throws FileNotFoundException {

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
            AutoGeneratOrders obj = new AutoGeneratOrders(orders, mass);
            Thread threadOrder = new Thread(obj); //создание потока
            threadOrder.setName("Поток:" + i);
            threadOrder.start();
            try {
                threadOrder.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*
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
                        Thread.sleep(1000);
                        threadUpdateWait.start();
                        threadUpdateWait.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    if (readNumber == 2) {
                        Thread threadUpdateProcessed = new Thread( new ACheckProcessed( orders ) );
                        try {
                            Thread.sleep(100);
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
        */

        ManagerOrderFile fileObj = new ManagerOrderFile();

        //fileObj.saveAll( orders );
        //fileObj.readAll();

        Scanner sc = new Scanner(System.in);

        System.out.print("ID заказа, который добавить в bin:");
        String id_order = sc.next();
        UUID id_ord = UUID.fromString( id_order );
        fileObj.saveById( id_ord );
        fileObj.readById( id_ord );

        ManagerOrderJSON jsonObj = new ManagerOrderJSON();

        System.out.print("ID заказа, который добавить в json:");
        id_order = sc.next();
        id_ord = UUID.fromString( id_order );
        jsonObj.saveById( id_ord );
        jsonObj.readById( id_ord );



    }

}
