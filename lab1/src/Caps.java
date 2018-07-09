import java.util.Scanner;
import java.util.UUID;

public class Caps extends Clothes {

    Caps(UUID id) {
        super(id);
    }

    Caps() {
        super();
    }

    private double money;
    private String name;
    private String firma;

    @Override
    public void create() {
        super.create();
        name = "Кепка";
        money = 0;
        firma = "0";
    }

    @Override
    public void read() {
        super.read();
        if (!firma.equals("")) {
            System.out.println("\tID:\t\t" + "\t" + id);
            System.out.println("\tНазвание:\t" + name);
            System.out.println("\tЦена:\t" + "\t" + money);
            System.out.println("\tФирма-производитель:\t" + firma + "\n");
        }
    }

    @Override
    public void update() {
        super.update();
        Scanner sc = new Scanner(System.in);
        //System.out.print("Введите название:\t");
        //this.name = sc.next();
        System.out.print("\nВведите цену [Формат ввода: 123 или 123,45]:\t");
        this.money = sc.nextDouble();
        System.out.print("Введите название фирмы-производителя:\t");
        this.firma = sc.next();
    }

    @Override
    public void delete(){
        super.delete();
        //name = "0";
        money = 0;
        firma = "";
    }
}
