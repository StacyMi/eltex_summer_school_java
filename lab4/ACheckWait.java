import WorkWithOrders.Orders;

public class ACheckWait extends ACheck{

   /* ACheckWait() {
        thread = new Thread( this, "Дополнительный поток В ОЖИДАНИИ" );
        System.out.println( "Создан дополнительный поток В ОЖИДАНИИ " + thread );
        thread.start();
    }
    */

    ACheckWait(Orders orders) {
        super(orders);
    }

    @Override
    public void run() {
       super.run();
        synchronized (super.orders) {

            System.out.printf( "'%s'\t",
                    Thread.currentThread().getName() );
            super.orders.updateStatus();
            System.out.println( "\t\t\t\t--->Статусы обновленны!<---\t\t\t\t" );
            super.orders.printAllOrders();
        }
    }

}
