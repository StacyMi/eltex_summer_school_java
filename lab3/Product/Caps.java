package Product;

import java.util.Scanner;

public class Caps extends Clothes {

    /*Product.Caps(UUID id) {
        super(id);
    }
*/
    public Caps() {
        super();
    }

    private String[] moneyZ = {"300", "150", "600", "225"};
    private String money;
    private String name;
    private String[] firmaZ = {"puma", "nike", "scetchers", "XXX"};
    private String firma;

    @Override
    public void create() {
        super.create();
        name = "Кепка";
        int moneyInd = (int) (Math.random() * moneyZ.length);
        this.money = moneyZ[moneyInd];
        int firmaInd = (int) (Math.random() * firmaZ.length);
        this.firma = firmaZ[firmaInd];
    }

    @Override
    public void read() {
        super.read();
        if (!firma.equals("")) {
            System.out.print(number + "\t\t" + id + "\t" + name + "\t\t" + money);
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
            System.out.print(id + "\t" + name + "\t\t" + money);
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

    }

    @Override
    public void delete(){
        super.delete();
        money = "";
        firma = "";
    }
}
