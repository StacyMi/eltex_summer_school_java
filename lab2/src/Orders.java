import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Orders {
    public static final int MAX = 20;
    //private static int index;

    Order[] order = new Order[MAX];
    LinkedList<String> link = new LinkedList<>();

    public void createOrder(ArrayList<String> list, Clothes[] mass, int count){
        Order orderNew = new Order();
        orderNew.creat(list, mass);
        link.add(orderNew.id.toString());
        order[count] = orderNew;

      /*
        order[index].creat(list, mass);
        link.add(order[index].id.toString());
        index++;
        */
    }
    public void testOrders(int count) {
        for (int i = 0; i < link.size(); i++) {
            //System.out.println(order[0].id);
            //System.out.println(link.get(i));
            for (int j = 0; j < count; j++)
                if (order[j].id.toString().equals(link.get(i))) {

                    //System.out.println(order[j].id.toString());
                    //System.out.println(link.get(i));
                    Date dateNow = new Date();
                    //System.out.println(order[j].dateWait);
                    //System.out.println(dateNow);
                    if (order[j].dateWait.getTime() < dateNow.getTime()) {
                        //link.remove(i);
                        order[j].statusUpdate();
                    }
                }
        }
    }
    public void print(Credentials user1, int count) {
        System.out.println("\nЗаказчик:");
        user1.printUser();
        System.out.println("Все имеющиеся заказы:");
        System.out.println("\n______________________________________________");
        for (int i = 0; i < link.size(); i++) {
            for (int j = 0; j < count; j++) {
                if(order[j].id.toString().equals(link.get(i))) {
                    System.out.println("Заказ\t" + (i+1));
                    System.out.println("ID заказа:\t" + order[j].id + "\nВремя создания заказа:\t" +
                            order[j].dateCreate.toString());
                    System.out.println("Заказ будет обработан(через 20мин.) в:\t" +
                            order[j].dateWait.toString());
                    System.out.printf("Статус:\t" + order[j].status);
                }
            }
            System.out.println("\n______________________________________________");
        }
    }
}
