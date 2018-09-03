package WorkWithThreads;

import WorkWithOrders.Orders;

public abstract class ACheck implements Runnable{
    final Orders orders;

    ACheck(Orders orders) {
        this.orders = orders;
    }
    @Override
    public void run() {
    }
}
