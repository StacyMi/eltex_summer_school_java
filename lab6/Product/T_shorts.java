package Product;

import sun.applet.Main;

import java.io.Serializable;
import java.util.Scanner;

public class T_shorts extends Clothes implements Serializable {


    public T_shorts(){
        super();
    }

   /* Product.T_shorts(UUID id) {
        super(id);
    }
*/
    private String[] moneyZ = {"1500", "2350", "680", "999"};
    private String[] firmaZ = {"puma", "nike", "scetchers", "XXX"};

    @Override
    public void create() {
        super.create();
        name = "Футболка";
        int moneyInd = (int) (Math.random() * moneyZ.length);
        this.money = moneyZ[moneyInd];
        int firmaInd = (int) (Math.random() * firmaZ.length);
        this.firma = firmaZ[firmaInd];
    }

    @Override
    public void read() {
        super.read();
        if (!firma.equals("")) {
            System.out.print(number + "\t\t" + id + "\t" + name + "\t" + money);
            if (money.length() == 3) {
                System.out.print("\t\t" + firma + "\n");
            } else {
                System.out.print("\t" + firma + "\n");
            }
            /*
            System.out.println("\tСчетчик:\t" + super.count);
            System.out.println("\tID:\t\t" + "\t" + id);
            System.out.println("\tНазвание:\t" + name);
            System.out.println("\tЦена:\t" + "\t" + money);
            System.out.println("\tФирма-производитель:\t" + firma + "\n");
        */
        }
    }

    @Override
    public void readBasket() {
        super.read();
        if (!firma.equals("")) {
            System.out.print(id + "\t" + name + "\t" + money);
            if (money.length() == 3) {
                System.out.print("\t\t" + firma + "\n");
            } else {
                System.out.print("\t" + firma + "\n");
            }
        }
    }

    @Override
    public void update() {
        super.update();

        Scanner sc = new Scanner(System.in);
        //System.out.print("Введите название:\t");
        //this.name = sc.next();
        System.out.print("\nВведите цену [Формат ввода: 123 или 123,45]:\t");
        this.money = sc.next();
        System.out.print("Введите название фирмы-производителя:\t");
        this.firma = sc.next();
        sc.close();

    }

    @Override
    public void delete(){
        super.delete();
        money = "";
        firma = "";
    }

}
