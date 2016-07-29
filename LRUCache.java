import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheMap<K,V> extends LinkedHashMap<K,V>{
	
	public void removeLRUEntry(){
		for(Map.Entry<K, V> e:entrySet()){
			remove(e.getKey());
			break;
		}
	}
	
}


public class LRUCache {
	private int capacity=0;
	private static int curSize=0;
	private LRUCacheMap<Integer,Integer> cacheMap;
	
public LRUCache(int capacity) {
        this.capacity=capacity;
        cacheMap=new LRUCacheMap<Integer,Integer>();
    }
    
    public int get(int key) {
    	int value=-1;
    	if(cacheMap.get(key)!=null){
    		value=cacheMap.get(key);
    		cacheMap.remove(key);
    		cacheMap.put(key, value);
    	}
    	return value;
        
    }
    
    public void set(int key, int value) {
    	if(cacheMap.get(key)!=null){
    		cacheMap.remove(key);
    	}
    	if(cacheMap.size()==capacity){
    		cacheMap.removeLRUEntry();
    	}
   
    	cacheMap.put(key, value);

    }
    
    public int getCapacity(){
    	return capacity;
    	
    }
    
    public int getCurrentSize(){
    	return curSize;
    }

}
