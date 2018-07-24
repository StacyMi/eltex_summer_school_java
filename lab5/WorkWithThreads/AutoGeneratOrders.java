package WorkWithThreads;

import Product.Clothes;
import WorkWithOrders.Credentials;
import WorkWithOrders.Orders;
import WorkWithOrders.ShoppingCart;


public class AutoGeneratOrders implements Runnable {

    private static final int MAX_SIZE_BASKET = 5;
    private static final int MIN_SIZE_BASKET = 1;
    private final Orders orders;
    private Clothes[] mass;

    public AutoGeneratOrders(Orders orders, Clothes[] mass) {
        this.orders = orders;
        this.mass = mass;
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
            //basket.print();

            Credentials user1 = new Credentials();
            user1.add();
            //user1.print();

            this.orders.createBuy( basket, user1 );

        }
    }
}
