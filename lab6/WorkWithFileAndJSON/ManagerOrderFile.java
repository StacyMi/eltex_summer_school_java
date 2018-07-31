package WorkWithFileAndJSON;

import WorkWithOrders.Order;
import WorkWithOrders.Orders;

import java.io.*;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {
    String path = "/home/anastasia/IdeaProjects/lab2/src/WorkWithFileAndJSON/file_all.bin";
    @Override
    public Order readById(UUID id) {
        super.readById( id );

        Orders readOrdersAll = readAll();
        Order readOrder = new Order();

        int i;
        int flag = 0;
        System.out.println("+++++++++++++read_by_id+++++++++++++");
        for(i = 0; i < readOrdersAll.link.size(); i++) {
            //System.out.println("id\t" + id);
            readOrder = (Order) readOrdersAll.link.get( i );
            //System.out.println("getId\t" + readOrder.id);
            if (readOrder.id.equals( id )) {
                printOrder( (Order) readOrdersAll.link.get( i ) );
                flag = 1;
            } else {
            }
        }
        if (flag != 1) {
            System.out.println("Заказ с таким ID отсутствует!");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        return readOrder;
    }

    @Override
    public void saveById(UUID id, Orders orders) {
        super.saveById( id , orders);

        Orders readOrdersAll = readAll();


        int i;
        int flag = 0;
        for (i = 0; i < readOrdersAll.link.size(); i++) {
            Order readOrder = (Order) readOrdersAll.link.get( i );
            if (readOrder.id.equals( id )) {
                flag = 1;
            }
        }
        if (flag != 1) {
            int flagOut = 0;
            for (i = 0; i < orders.link.size(); i++) {
                Order order = (Order) orders.link.get( i );
                if(order.id.equals( id )) {
                    readOrdersAll.link.add(order);
                    flagOut = 1;
                }
            }
            if (flagOut != 1) {
                System.out.println("В текущих заказах нет заказа с данным ID!");
            }
        } else {
            System.out.println("Заказ с таким ID уже есть!");
        }
        saveAll( readOrdersAll );
    }

    @Override
    public Orders readAll() {
        super.readAll();

        Orders readOrdersAll = new Orders();

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            try {
                readOrdersAll = (Orders) in.readObject();

            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int i;
        System.out.println("+++++++++++++read_all+++++++++++++");
        for (i = 0; i < readOrdersAll.link.size(); i++) {
            printOrder( (Order) readOrdersAll.link.get( i ) );
        }
        System.out.println("++++++++++++++++++++++++++++++++++");

        return readOrdersAll;
    }

    @Override
    public void saveAll(Orders orders) {
        super.saveAll( orders );

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(path));
            try {
                out.writeObject(orders);
                //out.close();
            } finally {out.close(); }
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}

    }

    private void printOrder(Order order){
        System.out.println("ID заказа:\t" + order.id + "\nВремя создания заказа:\t" + order.dateCreate.toString());
        System.out.println("Заказ будет обработан(через 1000 милисекунд) в:\t" + order.dateWait.toString());
        System.out.println("Статус:\t" + order.status);
        System.out.println("Заказчик:");
        order.userOrder.print();
        System.out.println("Состав заказа:\n");
        int index;
        for (index = 0; index < order.basketOrder.list.size(); index++) {
            order.basketOrder.list.get(index).readBasket();
        }
        System.out.println("______________________________________________");
    }
}
