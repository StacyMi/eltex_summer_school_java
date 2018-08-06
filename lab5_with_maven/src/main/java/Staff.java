import Product.Clothes;
import WorkWithOrders.Credentials;
import WorkWithOrders.ShoppingCart;

import java.util.Date;
import java.util.UUID;

public class Staff {
    protected UUID id;
    String status;
    Date dateCreate;
    Date dateWait;
    Credentials userOrder;
    ShoppingCart<Clothes> basketOrder;
}
