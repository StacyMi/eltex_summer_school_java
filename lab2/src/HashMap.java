import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class HashMap {
    Map<String, Integer> hashMap = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<Integer> values() {
            return null;
        }

        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };

    public void add(String id, Date date){
        String strDate = date.toString();
        hashMap.put(id, hashCode(strDate));
    }

    public void setHashMap(Map<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void print() {
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println("Ключ:\t" + hashMap.keySet());
            System.out.println("Значение:\t" + hashMap.values());
        }
    }
    public int hashCode(String date) {
        if(date.length()%2==0)
            return 31;
        else
            return 95;
    }
}
