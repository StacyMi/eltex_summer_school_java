import java.util.Iterator;
import java.util.TreeSet;

public class SaveIteratorInTreeSet {
    private TreeSet<String> treeSet = new TreeSet<>();

    void add(String id) {
        treeSet.add(id);
    }

    public int find(String idClothe) {
        Iterator<String> iterator = treeSet.iterator();
        int rezult = 0;

        while (iterator.hasNext()) {
            if (iterator.next().equals(idClothe)) {
                rezult = 1;
            }
        }
        return rezult;
    }
}
