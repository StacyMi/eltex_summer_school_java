package WorkWithOrders;

import Product.Clothes;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {

    public UUID id;
    public String status;
    public Date dateCreate;
    public Date dateWait;
    public Credentials userOrder;
    public ShoppingCart<Clothes> basketOrder;

    public Order() {id = UUID.randomUUID();}

    public void create(ShoppingCart<Clothes> basket, Credentials user1) {

        dateCreate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(dateCreate);
        cal.add(Calendar.MILLISECOND, Orders.MSECOND);
        dateWait = cal.getTime();
        status = Orders.STATUS_CREATE;

        this.basketOrder = basket;
        this.userOrder = user1;
        //print();

    }
    public void print(){
        System.out.println("ID заказа:\t" + this.id + "\nВремя создания заказа:\t" + dateCreate.toString());
        System.out.println("Заказ будет обработан(через 1000 милисекунд) в:\t" + dateWait.toString());
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
