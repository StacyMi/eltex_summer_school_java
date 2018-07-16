import java.util.Scanner;
import java.util.UUID;


class Credentials {
    private UUID id;
  /*  Credentials(UUID id) {
        this.id = id;
    }
    */
    Credentials(){
        id = UUID.randomUUID();
    }

    private String lastname;
    private String firstname;
    private String patronymic;
    private String eMail;


    void print() {
        System.out.println("______________________________________________");
        if (!this.firstname.equals("")) {
            System.out.printf("\nID:\t%s\nФамилия:\t%s\nИмя:\t%s\nОтчество:\t%s\ne-mail:\t%s", this.id, this.lastname, this.firstname, this.patronymic, this.eMail);
        }
        System.out.println("\n______________________________________________");
    }

    void add(){
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

    void update(){
        Scanner sc = new Scanner(System.in);

        int flagOut2 = 0;
        while (flagOut2 != 1) {

            System.out.println("\t1\t-\tИзменить фамилию");
            System.out.println("\t2\t-\tИзменить имя");
            System.out.println("\t3\t-\tИзменить отчество");
            System.out.println("\t4\t-\tИзменить e-mail");
            System.out.println("\t5\t-\tВведено все правильно ничего не менять!");

            System.out.print("\nВаш выбор:\t");
            int index = sc.nextInt();

            if (index >= 1 && index <= 5) {
                if (index == 1) {
                    System.out.println("Введите фамилию:\t");
                    this.lastname = sc.next();
                    print();
                } else {
                    if (index == 2) {
                        System.out.println("Введите имя:\t");
                        this.firstname = sc.next();
                        print();
                    } else {
                        if (index == 3) {
                            System.out.println("Введите отчество:\t");
                            this.patronymic = sc.next();
                            print();
                        } else {
                            if (index == 4) {
                                System.out.println("Введите e-mail:\t");
                                this.eMail = sc.next();
                                print();
                            } else {
                                flagOut2 = 1;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Вы ввели не корректные данные!\nПопробуйте еще раз!");
                //System.exit(0);
            }
        }
    }

    private void delete() {
        this.lastname = "";
        this.firstname = "";
        this.patronymic = "";
        this.eMail = "";
    }
}
