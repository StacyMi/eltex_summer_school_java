import Product.Clothes;

import java.util.*;

class Order {
    private static final int MIN = 20;
    private static final String STATUS_CREATE = "В ожидании";
   // private static final String STATUS_END = "Обработан";


    public UUID id;
    /*Order(UUID id) {this.id = id;}*/
    Order() {id = UUID.randomUUID();}

    public String status;
    private Date dateCreate;
    public Date dateWait;

    private ShoppingCart basketOrder;
    private Credentials userOrder;
    private Clothes[] Clothes;

    void create(ShoppingCart basket, Credentials user1, Clothes[] mass) {

        dateCreate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(dateCreate);
        cal.add(Calendar.MINUTE, MIN);
        dateWait = cal.getTime();
        status = STATUS_CREATE;

        this.basketOrder = basket;
        this.userOrder = user1;
        this.Clothes = mass;

        print();

    }
    void print(){
        System.out.println("ID заказа:\t" + this.id + "\nВремя создания заказа:\t" + dateCreate.toString());
        System.out.println("Заказ будет обработан(через 20мин.) в:\t" + dateWait.toString());
        System.out.println("Статус:\t" + status);
        System.out.println("Заказчик:");
        this.userOrder.print();
        System.out.println("Состав заказа:\n");
        int index, i;
        for (index = 0; index < this.basketOrder.list.size(); index++) {
            UUID listID = UUID.fromString(this.basketOrder.list.get(index));
            for (i = 0; i < this.Clothes.length; i++) {
                if (this.Clothes[i].id.equals(listID)) {
                    this.Clothes[i].readBasket();
                }
            }
        }
        System.out.println("______________________________________________");
    }
/*
    public static final int MIN = 20;

    UUID id;
    Order(UUID id) {this.id = id;}
    Order() {id = UUID.randomUUID();}

    String[] statusID = {"В ожидании", "Обработан"};
    int stID;
    String status;
    Date dateCreate;
    Date dateWait;

    public void creat(ArrayList<String> list, Clothes[] mass){
        this.stID = 0;
        this.status = statusID[stID];
        dateCreate = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(dateCreate);

        //Adding 21 Hours to your Date
        cal.add(Calendar.MINUTE, MIN);
        dateWait = cal.getTime();
        System.out.println("ID заказа:\t" + this.id + "\nВремя создания заказа:\t" + dateCreate.toString());
        System.out.println("Заказ будет обработан(через 20мин.) в:\t" + dateWait.toString());
        System.out.printf("Статус:\t" + status);
        print(mass, list);
    }
    public void print(Clothes[] mass, ArrayList<String> list){
        System.out.println("\n______________________________________________");
        System.out.println("Состав заказа:\n");
        for (int index = 0; index < list.size(); index++) {
            UUID listID = UUID.fromString(list.get(index));
            for (int i = 0; i < mass.length; i++) {
                if (mass[i].id.equals(listID)) {
                    mass[i].readBasket();
                }
            }
        }
        System.out.println("______________________________________________");
    }
    public void statusUpdate() {
        this.stID = 1;
        status = statusID[stID];
    }
*/

}
