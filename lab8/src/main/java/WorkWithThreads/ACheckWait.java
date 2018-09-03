package WorkWithThreads;

import WorkWithOrders.Orders;

import java.util.Date;

public class ACheckWait extends ACheck{

   /* WorkWithThreads.ACheckWait() {
        thread = new Thread( this, "Дополнительный поток В ОЖИДАНИИ" );
        System.out.println( "Создан дополнительный поток В ОЖИДАНИИ " + thread );
        thread.start();
    }
    */

    public ACheckWait(Orders orders) {
        super(orders);
    }

    @Override
    public void run() {
       super.run();
        synchronized (super.orders) {

            System.out.printf( "'%s'\t",
                    Thread.currentThread().getName() );
            super.orders.updateStatus();
            Date nowDate = new Date();
            //System.out.println( "\t\t\t\t--->Статусы обновленны!<---\tТекущее время:\t" + nowDate );
            //super.orders.printAllOrders();
        }
    }

}
