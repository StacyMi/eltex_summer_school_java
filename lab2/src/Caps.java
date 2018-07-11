import java.util.Scanner;
import java.util.UUID;

public class Caps extends Clothes {

    Caps(UUID id) {
        super(id);
    }

    Caps() {
        super();
    }

    String[] moneyZ = {"300", "150", "600", "225"};
    int moneyInd;
    private String money;
    private String name;
    String[] firmaZ = {"puma", "nike", "scetchers", "XXX"};
    int firmaInd;
    private String firma;

    @Override
    public void create() {
        super.create();
        name = "Кепка";
        money = "-";
        firma = "-";
    }

    @Override
    public void read() {
        super.read();
        if (!firma.equals("")) {
            System.out.print(super.count + "\t\t" + id + "\t" + name + "\t\t" + money);
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
    public void update() {
        super.update();
        moneyInd = 0 + (int) (Math.random() * moneyZ.length);
        this.money = moneyZ[moneyInd];
        firmaInd = 0 + (int) (Math.random() * firmaZ.length);
        this.firma = firmaZ[firmaInd];
       /* Scanner sc = new Scanner(System.in);
        //System.out.print("Введите название:\t");
        //this.name = sc.next();
        System.out.print("\nВведите цену [Формат ввода: 123 или 123,45]:\t");
        this.money = sc.nextInt();
        System.out.print("Введите название фирмы-производителя:\t");
        this.firma = sc.next();
        */
    }

    @Override
    public void delete(){
        super.delete();
        money = "";
        firma = "";
    }
}
