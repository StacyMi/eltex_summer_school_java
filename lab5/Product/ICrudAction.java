package Product;

import java.io.Serializable;

public interface ICrudAction extends Serializable {
    void create();
    void read();
    void update();
    void delete();
    void readBasket();
}
