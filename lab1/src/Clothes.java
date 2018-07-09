import java.util.UUID;

public abstract class  Clothes  implements ICrudAction{
    static private int count;
    UUID id;

    Clothes(UUID id) {
        this.id = id;
    }
    Clothes(){
        id = UUID.randomUUID();
    }

    @Override
    public void create(){
        count++;
        System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void delete(){
        count--;
        System.out.println("Счетчик товаров:\t" + count);
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {
    }
}
