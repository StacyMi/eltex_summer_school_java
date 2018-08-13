package WorkWithServerClient;

import Product.Caps;
import Product.Clothes;
import Product.T_shorts;
import WorkWithOrders.Credentials;
import WorkWithOrders.Order;
import WorkWithOrders.Orders;
import WorkWithThreads.ACheckProcessed;
import WorkWithThreads.ACheckWait;
import WorkWithThreads.AutoGeneratOrders;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static Orders<Order> orders = new Orders<>();
    private static Credentials user1 = new Credentials();
    private static String HOST = "localhost";
    private static int portDiapazonClientUDP = 3344;
    private static int[] massPortClientUDP = new int[11];
    private static int[] massStatusClientUDP = new int[11];

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

        user1.add();
        ginerateMassPortAndStatus();

        int portClientUDP = massPortClientUDP[(int) (Math.random() * massPortClientUDP.length)];
        int portStatusUDP = massStatusClientUDP[(int) (Math.random() * massStatusClientUDP.length)];

        System.out.println( "UDP порт:\t" + portClientUDP );
        System.out.println( "UDP порт status:\t" + portStatusUDP );

        int portNumber = Integer.parseInt( getPort( portClientUDP ) );
        System.out.println( "Порт:\t" + portNumber );
        int kolOrders = 2 + (int) (Math.random() * 5);
        System.out.println( "Количество заказов:\t" + kolOrders );
        Thread.sleep( 1000 );
        sendOrder( portNumber, kolOrders );
        //System.out.println("жду...");

        getStatus( portStatusUDP );


    }

    private static void getStatus(int port) {

        String smsStatus = "";
        try {
            DatagramSocket ds = new DatagramSocket( port );
            while (true) {
                DatagramPacket pack = new DatagramPacket( new byte[36], 36 );
                ds.receive( pack );
                smsStatus = new String( pack.getData() );
                System.out.println( "id обработанного заказа - " + smsStatus );
            }
        } catch (Exception e) {
            System.out.println( e );
        }
    }

    private static String getPort(int PORT) {

        String smsPort = "";
        try {
            DatagramSocket ds = new DatagramSocket( PORT );
            while (true) {
                DatagramPacket pack = new DatagramPacket( new byte[4], 4 );
                ds.receive( pack );
                smsPort = new String( pack.getData() );
                return smsPort;
            }
        } catch (Exception e) {
            System.out.println( e );
        }
        return smsPort;
    }

    private static void sendOrder(int socketNumber, int kolOrders) throws InterruptedException, ClassNotFoundException {

        int step = 1;
        try (Socket socket = new Socket( HOST, socketNumber );

             ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream() );
             ObjectInputStream ois = new ObjectInputStream( socket.getInputStream() )) {

            System.out.println( "Соединение установлено!" );

            Clothes[] mass = (Clothes[]) ois.readObject();
            printClothes( mass, mass.length );

            while (!socket.isOutputShutdown()) {

                generateOrder( mass, user1, orders );
                Thread.sleep( 1000 );
                oos.writeObject( orders.link.get( step - 1 ) );


                if (step == kolOrders) {
                    System.out.println( "Порт " + socketNumber + " закрыт!" );
                    oos.writeObject( "exit" );
                    socket.close();
                    break;
                } else {
                    oos.writeObject( "next" );
                }
                oos.flush();
                step++;
            }
            System.out.println( "Обмен данными закончен!" );
            oos.close();
            ois.close();
        } catch (IOException e) {
            System.err.println( "Сервер недоступен!" );
            System.exit( 1 );
        }
    }

    private static void printClothes(Clothes[] mass, int OBJECT) {
        System.out.println( "______________________________________________" );
        System.out.println( "№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n" );
        for (int i = 0; i < OBJECT; i++) {
            mass[i].read();
        }
        System.out.println( "______________________________________________" );
    }

    private static void generateOrder(Clothes[] mass, Credentials user1, Orders orders) {
        AutoGeneratOrders obj = new AutoGeneratOrders( orders, mass, user1 );
        Thread threadOrder = new Thread( obj );
        threadOrder.start();

    }

    private static void ginerateMassPortAndStatus() {
        int ind = 0;
        for (int i = portDiapazonClientUDP; i <= (portDiapazonClientUDP + 10); i++, ind++) {
            massPortClientUDP[ind] = i;
        }
        ind = 0;
        for (int i = (portDiapazonClientUDP + 11); i <= (portDiapazonClientUDP + 21); i++, ind++) {
            massStatusClientUDP[ind] = i;
        }

    }

}