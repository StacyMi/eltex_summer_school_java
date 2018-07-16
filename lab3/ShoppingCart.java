import Product.Clothes;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart<T extends Clothes> {

    List<T> list = new ArrayList<>();

    int add(T Clothe) {
        list.add(Clothe);
        return 1;
    }

    int delete(T Clothe) {
        int rezult = find(Clothe);
        if (rezult == 1) {
            list.remove(Clothe);
        }
        return rezult;
    }

    private int find(T Clothe) {
        int rezult = 0;
        int i;
        for(i = 0; i < list.size(); i++) {
            if (list.get( i ).equals( Clothe )) {
                rezult = 1;
            }
        }
        return rezult;
    }
    void print() {
        System.out.println("______________________________________________");
        System.out.println("В корзине:\n");
        int index;
        for (index = 0; index < list.size(); index++) {
            list.get(index).readBasket();
        }
        System.out.println("______________________________________________");
    }
}
