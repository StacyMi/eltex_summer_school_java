package WorkWithFileAndJSON;

import WorkWithOrders.Order;
import WorkWithOrders.Orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public interface IOrder {
    Order readById(UUID id);
    void saveById(UUID id, Orders orders);
    Orders readAll();
    void saveAll(Orders orders);
}
