import java.util.*;

class SaveDateCreateOrders {
    private Map<String, Date> hashMap = (Map<String, Date>) new HashMap<String, Date>();

    void addOrderAndDate(String idOrder, Date dateOrder){
        hashMap.put(idOrder, dateOrder);
    }

    String[] findOldOrder() {
        Iterator<Map.Entry<String, Date>> it = hashMap.entrySet().iterator();
        String[] idOrder = new String[hashMap.size()];
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<String, Date> list = it.next();
            Date nowDate = new Date();
            if (list.getValue().getTime() < nowDate.getTime()) {
                idOrder[i] = list.getKey();
            } else {
                idOrder[i] = "";
            }
            it.remove(); // дабы не было ConcurrentModificationException
            i++;
        }

        return idOrder;
    }
}
