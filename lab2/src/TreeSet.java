import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.TreeSet;

class treeSet {
    TreeSet<String> states = new TreeSet<String>();
    Iterator<String> iterator = states.iterator();

    public void add(String id) {
        states.add(id);
    }

    public void find(String id) {
        iterator = states.iterator();

        // Displaying the Tree set data
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("Now the size of tree set: " + states.size());
    }
}
