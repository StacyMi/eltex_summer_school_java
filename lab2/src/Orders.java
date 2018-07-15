import Product.Clothes;

import java.util.LinkedList;
import java.util.UUID;

class Orders {

    private LinkedList<Order> link = new LinkedList<>();
    private SaveIteratorInTreeSet treeSet = new SaveIteratorInTreeSet();
    private SaveDateCreateOrders hashMap = new SaveDateCreateOrders();

    void createBuy(ShoppingCart basket, Credentials user1, Clothes[] mass) {
        Order newOrder = new Order();
        newOrder.create(basket, user1, mass);
        link.add(newOrder);
        treeSet.add(newOrder.id.toString()); //для поиска по идентификатерам
        hashMap.addOrderAndDate(newOrder.id.toString(), newOrder.dateWait); //для последующей проверки по дате
    }

    void printAllOrders(){
        int i;
        for (i = 0; i < link.size(); i++) {
            int ind = i + 1;
            System.out.println("**************************************");
            System.out.println("\t\t\tЗАКАЗ №\t" + ind);
            System.out.println("**************************************");
            link.get(i).print();
        }
    }

    void testStatusAndTime(){
        String[] massWithIdOldOrders;
        massWithIdOldOrders = hashMap.findOldOrder();
        UUID idOldOrder;
        int i, j;
        for (i = 0; i < massWithIdOldOrders.length; i++) {
            if (!massWithIdOldOrders[i].equals("")) {
                idOldOrder = UUID.fromString(massWithIdOldOrders[i]);
                for (j = 0; j < link.size(); j++) {
                    if(link.get(j).id == idOldOrder) {
                        link.remove(j);
                    }
                    if(link.get(j).status.equals("Обработан")) {
                        link.remove(j);
                    }
                }
            }

        }
    }
}
