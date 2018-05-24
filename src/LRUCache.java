import java.util.*;
import java.util.LinkedList;

class LRUCache {
    LinkedList lru;
    Map<Integer,Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.lru = new LinkedList();
        this.capacity = capacity;
        this.map = new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        if(map.get(key) != null) {
            lru.remove(Integer.valueOf(key));
            lru.addLast(Integer.valueOf(key));
            return map.get(key);
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.get(key) != null) {
            lru.remove(key);
            lru.addLast(key);
            if(lru.size() > this.capacity)
                lru.removeFirst();
            map.put(key, map.get(key));
        } else {
            lru.addLast(key);
            map.put(key,value);
        }
    }
}
