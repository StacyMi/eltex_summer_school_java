package WorkWithOrders;

import Product.Clothes;

import java.util.*;

public class Order extends Orders {
    private static final int MIN = 1;
    private static final String STATUS_CREATE = "В ожидании";
    static final String STATUS_END = "Обработан";


    UUID id;
    /*WorkWithOrders.Order(UUID id) {this.id = id;}*/
    Order() {id = UUID.randomUUID();}

    String status;
    private Date dateCreate;
    Date dateWait;

    private ShoppingCart<Clothes> basketOrder;
    private Credentials userOrder;
   // private Clothes[] Clothes;

    void create(ShoppingCart<Clothes> basket, Credentials user1) {

        dateCreate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(dateCreate);
        cal.add(Calendar.MINUTE, MIN);
        dateWait = cal.getTime();
        status = STATUS_CREATE;

        this.basketOrder = basket;
        this.userOrder = user1;
        print();

    }
    void print(){
        System.out.println("ID заказа:\t" + this.id + "\nВремя создания заказа:\t" + dateCreate.toString());
        System.out.println("Заказ будет обработан(через 1мин.) в:\t" + dateWait.toString());
        System.out.println("Статус:\t" + status);
        System.out.println("Заказчик:");
        this.userOrder.print();
        System.out.println("Состав заказа:\n");
        int index;
        for (index = 0; index < this.basketOrder.list.size(); index++) {
                this.basketOrder.list.get(index).readBasket();
        }
        System.out.println("______________________________________________");
    }

}
