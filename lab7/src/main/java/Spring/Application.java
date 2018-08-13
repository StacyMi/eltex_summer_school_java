package Spring;
import Product.*;
import WorkWithOrders.*;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {




    private static final int OBJECT = 5;
    static Clothes[] mass = new Clothes[OBJECT];
    static Credentials user1 = new Credentials();
    public static final Orders<Order> orders = new Orders<>();

    public static void main(String[] args) {

        user1.add();
        generateClothes();
        SpringApplication.run(Application.class, args);

    }

    public static void generateClothes() {

        String[] capsORt_shorts = {"caps", "t_shorts"};
        int capsORt_shortsInd;
        String caps = "caps";
        String t_shorts = "t_shorts";

        System.out.println("______________________________________________");
        System.out.println("№\t\t\t\t\t\tID\t\t\t\t\t\tНазвание\tЦена\tФирма-производитель\n");

        for (int i = 0; i < OBJECT; i++) {
            capsORt_shortsInd = (int)(Math.random() * capsORt_shorts.length);
            String view = capsORt_shorts[capsORt_shortsInd];
            if (view.equals(t_shorts) || view.equals(caps)) {
                if (view.equals(t_shorts)) {
                    mass[i] = new T_shorts();
                }
                if (view.equals(caps)) {
                    mass[i] = new Caps();
                }
            }
            mass[i].create();
            mass[i].read();
        }
        System.out.println("______________________________________________");
    }

}