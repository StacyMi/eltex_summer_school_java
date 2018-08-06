package WorkWithOrders;

import Product.Clothes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Orders<T extends Order> implements Serializable {

    static final int MSECOND = 1000;
    static final String STATUS_CREATE = "В ожидании";
    static final String STATUS_END = "Обработан";

    public List<T> link = new LinkedList<>();
    private static SaveIteratorInTreeSet treeSet = new SaveIteratorInTreeSet();
    public static SaveDateCreateOrders hashMap = new SaveDateCreateOrders();

    public void createBuy(ShoppingCart<Clothes> basket, Credentials user1) {
        T newOrder = (T) new Order();
        newOrder.create(basket, user1);
        link.add(newOrder);
        treeSet.add(newOrder.id.toString()); //для поиска по идентификатерам
        hashMap.addOrderAndDate(newOrder); //для последующей проверки по дате
    }

    public void printAllOrders(){
        int i;

        if (link.size() != 0) {
            for (i = 0; i < link.size(); i++) {
                int ind = i + 1;
                System.out.println( "**************************************" );
                System.out.println( "\t\t\tЗАКАЗ №\t" + ind );
                System.out.println( "**************************************" );
                link.get( i ).print();
            }
        }
    }
    public void printOrderID(Order order){
        System.out.println( "**************************************" );
        System.out.println( "\t\t\tЗАКАЗ" );
        System.out.println( "**************************************" );
        order.print();
    }

    public void deleteStatusProcessed(){
        int ind = link.size();
        ind--;
        while (ind != -1) {
            //System.out.println("i" + ind + "  " + link.get( ind ).status);
            if(link.get( ind ).status.equals(STATUS_END ))  {
                link.remove( ind );
                ind--;
            }
        }
    }
    public void updateStatus() {
        hashMap.updateStatusOrder();
    }

}
