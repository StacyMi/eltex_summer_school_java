package WorkWithThreads;

import Product.Clothes;
import WorkWithOrders.Credentials;
import WorkWithOrders.Order;
import WorkWithOrders.Orders;
import WorkWithOrders.ShoppingCart;


public class AutoGeneratOrders implements Runnable {

    private static final int MAX_SIZE_BASKET = 5;
    private static final int MIN_SIZE_BASKET = 1;
    private Orders orders;
    private Clothes[] mass;
    private Credentials user1;

    public AutoGeneratOrders(Orders orders, Clothes[] mass, Credentials user1) {
        this.orders = orders;
        this.mass = mass;
        this.user1 = user1;

    }
    @Override
    public void run() {
        synchronized (this.orders) {
            ShoppingCart<Clothes> basket = new ShoppingCart<>();
            int sizeBasket = MIN_SIZE_BASKET + (int) (Math.random() * MAX_SIZE_BASKET);
            int i;
            for (i = 0; i < sizeBasket; i++) {
                int ind = (int) (Math.random() * this.mass.length);
                basket.add( this.mass[ind] );
            }
            this.orders.createBuy( basket, user1 );

        }
    }
}
