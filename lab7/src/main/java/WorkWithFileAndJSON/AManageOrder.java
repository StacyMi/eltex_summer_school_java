package WorkWithFileAndJSON;

import WorkWithOrders.Order;
import WorkWithOrders.Orders;

import java.util.UUID;

public abstract class AManageOrder implements IOrder {

    @Override
    public Order readById(UUID id) {
        return null;
    }

    @Override
    public void saveById(UUID id, Orders orders) {

    }

    @Override
    public Orders readAll() {
        return null;
    }

    @Override
    public void saveAll(Orders orders) {

    }
}
