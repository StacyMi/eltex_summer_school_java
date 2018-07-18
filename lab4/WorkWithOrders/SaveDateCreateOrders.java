package WorkWithOrders;

import java.util.*;

public class SaveDateCreateOrders {
    private Map<Order, Date> hashM = (Map<Order, Date>) new HashMap<Order, Date>();

    void addOrderAndDate(Order order){
        hashM.put(order, order.dateWait);
    }

    void updateStatusOrder() {
        for (Map.Entry<Order, Date> entry : hashM.entrySet()) {
           // WorkWithOrders.Order order = entry.getKey();
            Date orderTimeWait = entry.getValue();
            Date nowDate = new Date();
            if (orderTimeWait.getTime() < nowDate.getTime()) {
                entry.getKey().status = Order.STATUS_END;
            }
        }
    }
}
