
import WorkWithOrders.Order;
import WorkWithOrders.Orders;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.*;
import java.util.UUID;


public class ManagerOrderJSON extends AManageOrder {
    @Override
    public Order readById(UUID id) {
        super.readById(id);

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
    public void saveById(UUID id) {
        super.saveById( id );

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
            for (i = 0; i < Main.orders.link.size(); i++) {
                if(Main.orders.link.get( i ).id.equals( id )) {
                    readOrdersAll.link.add(Main.orders.link.get( i ));
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

        ObjectMapper mapper = new ObjectMapper();
        Orders ordersRead = new Orders();

        try (FileReader reader = new FileReader("/home/anastasia/IdeaProjects/lab2/src/file_all.json")) {

            //String jsonString = mapper.readValue(reader, String.class);
            //System.out.println("json read --> " + jsonString);

            ordersRead = mapper.readValue(reader, Orders.class);
            int i;
            System.out.println("+++++++++++++read_all+++++++++++++");
            for (i = 0; i < ordersRead.link.size(); i++) {
                printOrder( (Order) ordersRead.link.get( i ) );
            }
            System.out.println("++++++++++++++++++++++++++++++++++");
            //printOrder( orders_read );

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ordersRead;
    }

    @Override
    public void saveAll(Orders orders) {
        super.saveAll( orders );

        // convert to json
        ObjectMapper mapper = new ObjectMapper();

        try (FileWriter writer = new FileWriter("/home/anastasia/IdeaProjects/lab2/src/file_all.json")) {
            String jsonString = mapper.writeValueAsString(orders);
            System.out.println("json save --> " + jsonString);

            mapper.writeValue(writer, orders);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

