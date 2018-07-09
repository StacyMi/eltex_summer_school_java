public class Main {
/*
    public Main(int i) {

        //Коструктор необходим для инициализация начальных параметров объектов

        this.i = i;

    }
    public int i;

    public void read(int[] mass) {      //Передается ссылка на массив
        for (int i=0; i < mass.length; i++) {
            mass[i]++;  //пробежаться по всем элементам массива
            System.out.println("");
        }
    }
*/
    public static void main(String[] args) {

        System.out.println("3 вариант! [Входные данные: t_shorts или caps]");
        String view = args[0];
        int inputObject = Integer.parseInt(args[1]);

         System.out.printf("\nВид представления: %s\tКоличество вводимых объектов: %d\n",view, inputObject);
         Clothes[] mass = new Clothes[inputObject];
         String caps = "caps";
         String t_shorts = "t_shorts";

        System.out.println("\n--->Инициализация:");
         for (int i = 0; i < inputObject; i++) {
             if (view.equals(t_shorts) || view.equals(caps)) {
                 if (view.equals(t_shorts)) {
                     mass[i] = new T_shorts();
                 // T_shorts t_shorts = new T_shorts();
                 //Clothes clothes = t_shorts;
                 //clothes.create(inputObject);
                 }
                 if (view.equals(caps)) {
                     mass[i] = new Caps();
                     // T_shorts t_shorts = new T_shorts();
                     //t_shorts.create(inputObject);
                 }
             } else {
                 System.out.println("\nТакого вид предсталения не предусмотренно!\n" +
                         "Запустите программу заного и введите новые параметры!\n");
                 break;
             }

             mass[i].create();
             mass[i].read();
         }
        System.out.println("\n--->Ввод/обновление двнных:");
         for (int i = 0; i < inputObject; i++) {
             mass[i].update();
         }
        System.out.println("\n--->Проверка обнавленных данных:");
        for (int i = 0; i < inputObject; i++) {
            mass[i].read();
        }
        System.out.println("\n--->Пример удаления из списка:");
         mass[2].delete();
        for (int i = 0; i < inputObject; i++) {
            mass[i].read();
        }

         /*

        Main main = new Main(10);   // main - это уже ссылка на объект
        Main mass[] = new Main[10];
        int massInt[] = new int[10];
        System.out.println(main.i);

*/
/*
        String[][] table = new String[inputObject + 1][5];
        table[0][0] = "ID товара";
        table[0][1] = "Название";
        table[0][2] = "Цена";
        table[0][3] = "Счетчик товара";
        table[0][4] = "Фирма производитель";

        for (int i = 1; i <= inputObject; i++) {
            for (int j = 0; j < 5; j++) {

                if (j == 0) {
                    table[i][j] = String.valueOf(i);
                } else {
                    table[i][j] = String.valueOf(0);
                }
            }
            System.out.println("\n");
        }

        for (int i = 0; i <= inputObject; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    System.out.print(table[i][j] + "\t");
                } else {
                    System.out.print("\t" + table[i][j] + "\t");
                    System.out.print("\t");
                }

            }
            System.out.println();
        }
    */

    }

}
