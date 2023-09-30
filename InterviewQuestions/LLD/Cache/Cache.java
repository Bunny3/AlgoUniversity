package LLD.Cache;

import java.util.HashMap;
import java.util.Map;

class Cache {
  private final EvictionPolicy evictionPolicy;
  private final Storage storage;
  public Cache(EvictionPolicy evictionPolicy, Storage storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  public void put(String key, String value) {
    this.storage.add(key,value);
    this.evictionPolicy.keyAccessed(key);
  }

  public int get(String key) {
    String value = this.storage.get(key);
    this.evictionPolicy.keyAccessed(key);;
  }
}

class Storage {
  Map<String , String> storage;
  private final Integer capacity;
  public Storage(Integer capacity) {
    this.capacity = capacity;
  }

  public void add(String key, String value) {
    if(storage.size() == capacity) {
      System.out.println("Capacity is Full");
    }
    storage.put(key,value);
  }

  public String get(String key) {
    return storage.get(key);
  }

  public void delete(String key) {
    if(!storage.containsKey(key))
      return;
    storage.remove(key);
  }
  
}

class DLL {}
class DLLN {}
class EvictionPolicy {
  private DLL dll;
  private Map<String, DLLN> mapper;
  public EvictionPolicy() {
    this.dll = new DLL();
    this.mapper = new HashMap<>();
  }
  public void keyAccessed(String key) {
    detachNode(mapper.get(key));
    addNodeAtEnd(mapper.get(key));
    return;
  }
  public void evictKey() {
    dll.moveHead();
    return;
  }
}