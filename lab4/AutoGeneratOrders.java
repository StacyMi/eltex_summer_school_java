import Product.Clothes;
import WorkWithOrders.Credentials;
import WorkWithOrders.Order;
import WorkWithOrders.Orders;
import WorkWithOrders.ShoppingCart;

public class AutoGeneratOrders implements Runnable {

    private static final int MAX_SIZE_BASKET = 5;
    private static final int MIN_SIZE_BASKET = 1;

    AutoGeneratOrders() {
    }
    @Override
    public void run() {
        synchronized (Main.orders) {
            ShoppingCart<Clothes> basket = new ShoppingCart<>();
            int sizeBasket = MIN_SIZE_BASKET + (int) (Math.random() * MAX_SIZE_BASKET);
            int i;
            for (i = 0; i < sizeBasket; i++) {
                int ind = (int) (Math.random() * Main.mass.length);
                basket.add( Main.mass[ind] );
            }
            //basket.print();

            Credentials user1 = new Credentials();
            user1.add();
            //user1.print();

            Main.orders.createBuy( basket, user1 );

        }
    }
}
