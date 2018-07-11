import java.util.Scanner;
import java.util.UUID;

//
public class Credentials {
    UUID id;
    Credentials(UUID id) {
        this.id = id;
    }
    Credentials(){
        id = UUID.randomUUID();
    }

    private String lastname;
    private String firstname;
    private String patronymic;
    private String eMail;
    private int index;

    public void printUser() {
        System.out.println("______________________________________________");
        System.out.printf("\nID:\t%s\nФамилия:\t%s\nИмя:\t%s\nОтчество:\t%s\ne-mail:\t%s", this.id, this.lastname, this.firstname,
                this.patronymic, this.eMail);
        System.out.println("\n______________________________________________");
    }

    public void addUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nВведите фамилию:\t");
        this.lastname = sc.next();
        System.out.print("Введите имя:\t");
        this.firstname = sc.next();
        System.out.print("Введите отчество:\t");
        this.patronymic = sc.next();
        System.out.print("Введите e-mail:\t");
        this.eMail = sc.next();
    }

    public void editUser(){
        int flagOut = 0;
        while (flagOut != 1) {
            this.index = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("\t1\t-\tИзменить фамилию");
            System.out.println("\t2\t-\tИзменить имя");
            System.out.println("\t3\t-\tИзменить отчество");
            System.out.println("\t4\t-\tИзменить e-mail");
            System.out.println("\t5\t-\tВведено все правильно ничего не менять!");
            System.out.print("\nВаш выбор:\t");
            this.index = sc.nextInt();
            if (this.index >= 1 && this.index <= 5) {
                if (this.index == 1) {
                    System.out.println("Введите фамилию:\t");
                    this.lastname = sc.next();
                    printUser();
                }
                if (this.index == 2) {
                    System.out.println("Введите имя:\t");
                    this.firstname = sc.next();
                    printUser();
                }
                if (this.index == 3) {
                    System.out.println("Введите отчество:\t");
                    this.patronymic = sc.next();
                    printUser();
                }
                if (this.index == 4) {
                    System.out.println("Введите e-mail:\t");
                    this.eMail = sc.next();
                    printUser();
                }
                if (this.index == 5) {
                    flagOut = 1;
                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
                //System.exit(0);
            }
        }
    }
    public void deleteUser() {
        this.lastname = "";
        this.firstname = "";
        this.patronymic = "";
        this.eMail = "";
    }

}
