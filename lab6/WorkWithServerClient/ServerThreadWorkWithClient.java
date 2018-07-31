package WorkWithServerClient;

import WorkWithOrders.Order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThreadWorkWithClient implements Runnable {

    private Socket clientDialog;

    public ServerThreadWorkWithClient(Socket client) {
        this.clientDialog = client;
    }

    @Override
    public void run() {
        try {

            System.out.println( "Соединение установленно!" );

            ObjectOutputStream out = new ObjectOutputStream( clientDialog.getOutputStream() );
            ObjectInputStream in = new ObjectInputStream( clientDialog.getInputStream() );


            out.writeObject( Server.mass );
            while (!clientDialog.isClosed()) {

                Order order = (Order) in.readObject();
                System.out.println( "**************************************" );
                System.out.println( "\t\t\tЗАКАЗ\t" );
                System.out.println( "**************************************" );
                order.print();

                Server.queue.add( order );
                Server.orders.link.add( order );
                Server.orders.hashMap.addOrderAndDate( order );
                Thread.sleep( 1000 );

                String stop = (String) in.readObject();
                if (stop.equalsIgnoreCase( "exit" )) {

                    break;
                }

                out.flush();

            }
            System.out.println( "Обмен данными закончен!" );
            in.close();
            out.close();
            clientDialog.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
