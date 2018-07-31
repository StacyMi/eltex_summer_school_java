package WorkWithServerClient;

import Product.Caps;
import Product.Clothes;
import Product.T_shorts;
import WorkWithOrders.Order;
import WorkWithOrders.Orders;
import WorkWithThreads.ACheckProcessed;
import WorkWithThreads.ACheckWait;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class Server {

    private static final int OBJECT = 5;
    public static Clothes[] mass = new Clothes[OBJECT];

    private static int portDiapazonPort = 3344;
    private static int PORT = 3333;
    private static String HOST = "localhost";
    private static String statusExit = "Обработан";


    static Queue<Order> queue = new LinkedList<>();
    static Orders<Order> orders = new Orders<>();

    public static void main(String[] args) {

        generateClothes();

        new Thread( new Runnable() {
            public void run() {
                while (true) {
                    try {
                        for (int i = portDiapazonPort; i <= (portDiapazonPort + 10); i++) {
                            sendPortUDP( i );
                        }
                        Thread.sleep( 10000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } ).start();

        new Thread( new Runnable() {
            public void run() {
                while (true) {
                    try {
                        //Thread.sleep( 10000 );
                        updateStatus( orders );
                        for (int i = (portDiapazonPort + 11); i <= (portDiapazonPort + 21); i++) {
                            sendStatusUDP( i );
                        }
                        deleteUpdateStatus( orders );
                        Thread.sleep( 10000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        } ).start();

        workServer();
    }

    private static void sendStatusUDP(int port) {
        try {
            DatagramSocket ds = new DatagramSocket();
            for (int j = 0; j < orders.link.size(); j++) {
                if (orders.link.get( j ).status.equals( statusExit )) {
                    String msg = String.valueOf( orders.link.get( j ).id );
                    byte[] data = msg.getBytes();
                    InetAddress addr = InetAddress.getByName( HOST );
                    DatagramPacket pack = new DatagramPacket( data, data.length, addr, port );
                    ds.send( pack );
                }
            }
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendPortUDP(int port) {
        try {
            String msg = String.valueOf( PORT );
            byte[] data = msg.getBytes();
            InetAddress addr = InetAddress.getByName( HOST );
            DatagramPacket pack = new DatagramPacket( data, data.length, addr, port );
            DatagramSocket ds = new DatagramSocket();
            ds.send( pack );
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workServer() {
        try (ServerSocket server = new ServerSocket( PORT );
             BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) )) {

            while (true) {

                Socket client = server.accept();

                ServerThreadWorkWithClient obj = new ServerThreadWorkWithClient( client );
                Thread t = new Thread( obj );
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateClothes() {
        String[] capsORt_shorts = {"caps", "t_shorts"};
        int capsORt_shortsInd;
        String caps = "caps";
        String t_shorts = "t_shorts";

        System.out.println( "______________________________________________" );
        System.out.println( "№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n" );

        for (int i = 0; i < OBJECT; i++) {
            capsORt_shortsInd = (int) (Math.random() * capsORt_shorts.length);
            String view = capsORt_shorts[capsORt_shortsInd];
            if (view.equals( t_shorts ) || view.equals( caps )) {
                if (view.equals( t_shorts )) {
                    mass[i] = new T_shorts();
                }
                if (view.equals( caps )) {
                    mass[i] = new Caps();
                }
            }
            mass[i].create();
            mass[i].read();
        }
        System.out.println( "______________________________________________" );
    }

    private static void updateStatus(Orders orders) {

        Thread threadUpdateWait = new Thread( new ACheckWait( orders ) );
        try {
            threadUpdateWait.start();
            threadUpdateWait.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void deleteUpdateStatus(Orders orders) {
        Thread threadUpdateWait = new Thread( new ACheckProcessed( orders ) );
        try {
            threadUpdateWait.start();
            threadUpdateWait.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
