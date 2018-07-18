package WorkWithOrders;

import Product.Clothes;

import java.util.LinkedList;
import java.util.List;


public class Orders<T extends Order> {

    private List<T> link = new LinkedList<>();
    private SaveIteratorInTreeSet treeSet = new SaveIteratorInTreeSet();
    public SaveDateCreateOrders hashMap = new SaveDateCreateOrders();

    public void createBuy(ShoppingCart<Clothes> basket, Credentials user1) {
        T newOrder = (T) new Order();
        newOrder.create(basket, user1);
        link.add(newOrder);
        treeSet.add(newOrder.id.toString()); //для поиска по идентификатерам
        hashMap.addOrderAndDate(newOrder); //для последующей проверки по дате
    }

    public void printAllOrders(){
        int i;
        for (i = 0; i < link.size(); i++) {
            int ind = i + 1;
            System.out.println("**************************************");
            System.out.println("\t\t\tЗАКАЗ №\t" + ind);
            System.out.println("**************************************");
            link.get(i).print();
        }
    }

    public void deleteStatusProcessed(){
        int ind;
        for (ind = 0; ind < link.size(); ind++) {
            if(link.get( ind ).status.equals( Order.STATUS_END ))  {
                link.remove( ind );
            }
        }
    }
    public void updateStatus() {
        hashMap.updateStatusOrder();
    }

}
