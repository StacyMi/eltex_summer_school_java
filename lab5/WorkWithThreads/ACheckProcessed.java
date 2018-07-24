package WorkWithThreads;

import WorkWithOrders.Orders;

public class ACheckProcessed extends ACheck {

   /* WorkWithThreads.ACheckProcessed() {
        thread = new Thread( this, "Дополнительный поток ОБРАБОТАН" );
        System.out.println( "Создан дополнительный поток ОБРАБОТАН" + thread );
        thread.start();
    }
    */

    public ACheckProcessed(Orders orders) {
        super(orders);
    }

    @Override
    public void run() {
        super.run();
        synchronized (super.orders) {


            System.out.printf( "'%s'\t",
                    Thread.currentThread().getName() );
            super.orders.deleteStatusProcessed();
            System.out.println( "\t\t\t\t--->Удалены все заказы со статусом ОБРАБОТАН!<---\t\t\t\t" );
            super.orders.printAllOrders();

        }
    }
}
