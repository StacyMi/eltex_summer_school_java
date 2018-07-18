package WorkWithOrders;

import java.util.Scanner;
import java.util.UUID;


public class Credentials {
    private UUID id;
  /*  WorkWithOrders.Credentials(UUID id) {
        this.id = id;
    }
    */
  public Credentials(){
        id = UUID.randomUUID();
    }

    private String[] AllLastname = {"Петров", "Иванов", "Сидоров"};
  private String[] AllFirstname = {"Игорь", "Иван", "Андрей"};
  private String[] AllPatronomic = {"Николаевич", "Сергеевич", "Валерьевич"};
  private String[] AlleMail = {"frendsD@ya.ru", "GoodH@gmail.com", "pop49@icloud.com"};
    private String lastname;
    private String firstname;
    private String patronymic;
    private String eMail;


    public void print() {
        System.out.println("______________________________________________");
        if (!this.firstname.equals("")) {
            System.out.printf("\nID:\t%s\nФамилия:\t%s\nИмя:\t%s\nОтчество:\t%s\ne-mail:\t%s\n", this.id, this.lastname, this.firstname, this.patronymic, this.eMail);
        }
        System.out.println("\n______________________________________________");
    }

    public void add(){

        //System.out.print("\nВведите фамилию:\t");
        int indLastname = (int) (Math.random() * AllLastname.length);
        this.lastname = AllLastname[indLastname];

        //System.out.print("Введите имя:\t");
        int indFirstname = (int) (Math.random() * AllFirstname.length);
        this.firstname = AllFirstname[indFirstname];

        //System.out.print("Введите отчество:\t");
        int indPatronomic = (int) (Math.random() * AllPatronomic.length);
        this.patronymic = AllPatronomic[indPatronomic];

       // System.out.print("Введите e-mail:\t");
        int indeMail = (int) (Math.random() * AlleMail.length);
        this.eMail = AlleMail[indeMail];

    }

    public void update(){
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
