import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class LFULinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    int capacity;

    //constructor
    public LFULinkedHashMap(int capacity){
        //调用LinkedHashMap的构造器，传入以下参数
        super(capacity,0.75f,true);
        //传入指定的缓存最大容量
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> var1) {
        return size()>capacity;
    }
}
