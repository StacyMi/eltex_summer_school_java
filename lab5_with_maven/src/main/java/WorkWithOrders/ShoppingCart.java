package WorkWithOrders;

import Product.Clothes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends Clothes> implements Serializable {

    public List<T> list = new ArrayList<>();

    public int add(T Clothe) {
        list.add(Clothe);
        return 1;
    }

    public int delete(T Clothe) {
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
    public void print() {
        System.out.println("______________________________________________");
        System.out.println("В корзине:\n");
        int index;
        for (index = 0; index < list.size(); index++) {
            list.get(index).readBasket();
        }
        System.out.println("______________________________________________");
    }
}
