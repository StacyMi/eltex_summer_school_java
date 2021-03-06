package Product;

import java.util.UUID;

public abstract class Clothes implements ICrudAction {
    public static int number;
    static int count;
    public UUID id;

    /*
    Clothes(UUID id) {
        this.id = id;
    }
    */
    Clothes(){
        id = UUID.randomUUID();
    }

    @Override
    public void create(){
        count++;
        //System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void delete(){
        count--;
        //System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void read() {
        number++;
    }

    @Override
    public void update() {
    }

    @Override
    public void readBasket(){

    }

}
