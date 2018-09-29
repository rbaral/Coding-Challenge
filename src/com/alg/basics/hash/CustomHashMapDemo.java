/*
this is a sample implementation of HashMap. It does the followings:
-compute the hash key for a given code, we use the mod operator on the size of the bucket we are going to use for our hashmap
 */
package com.alg.basics.hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rbaral
 */
class Entry<K, V> {

    Entry<K, V> next;
    K key;
    V value;

    public Entry(K key, V val) {
        this.key = key;
        this.value = val;
    }

    public K getKey() {
        return this.key;
    }

    public void setValue(V val) {
        this.value = val;
    }

    public V getValue() {
        return this.value;
    }

    public void setNext(Entry<K, V> e) {
        this.next = e;
    }

    public Entry<K, V> getNext() {
        return this.next;
    }
}

class CustomHashMap<K, V> {

    //how many elements to start
    int bufferSize = 100;
    //lets create a bucket to hold the items
    Entry<K, V>[] buckets;
    int size;
    public CustomHashMap() {
        buckets = new Entry[bufferSize];
        size = 0;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public int size(){
        return size;
    }
    
    /**
     * remove from hash and return, if the given key exist
     * @param key
     * @return 
     */
    public Entry<K,V> remove(K key) throws Exception{
        Entry<K,V> item = null;
        int hashKey = getHashKey(key);
        //check if the index at this point is empty
        if (buckets[hashKey] == null) {
            //item does not exist, throw exception
            throw new Exception("Key does not exist");
        } else {
            Entry<K, V> existing = buckets[hashKey];
            //check if the same element exist, if so replace the value
            if (existing.getKey() == key) {
                //remove from hash
                buckets[hashKey] = existing.next;
                size--;
                return existing;
            } else {
                //need to use chaining, get the existing one and create a linked list on it
                while(existing.next!=null){
                    if(existing.getKey()==key){
                        //remove this tiem from hash
                        buckets[hashKey] = existing.next;
                        size--;
                        return existing;
                    }
                }
            }
        }
        return item;
    }
    
    /**
     * java provides a unique integer for each object using its address, we use
     * that integer and take mode with the buffer size so that we do not require
     * very big buffer
     *
     * @param key
     * @return
     */
    public int getHashKey(K key) {
        return (int) Math.ceil(key.hashCode() % bufferSize);
    }

    public void put(K key, V value) {
        //lets find the index in the bucket that matches hash value of this key
        int hashKey = getHashKey(key);
        //check if the index at this point is empty
        if (buckets[hashKey] == null) {
            buckets[hashKey] = new Entry(key, value);
        } else {
            Entry<K, V> existing = buckets[hashKey];
            //check if the same element exist, if so replace the value
            if (existing.getKey() == key) {
                existing.setValue(value);
            } else {
                //need to use chaining, get the existing one and create a linked list on it
                existing.next = new Entry(key, value);
                buckets[hashKey] = existing;
            }
        }
        size++;
    }

    public V get(K key) throws Exception {
        int hashKey = getHashKey(key);
        if (buckets[hashKey] == null) {
            throw new Exception("Key not found exception");
        } else {
            //this key might be the only element in the index or there might be others also, so check until we get a match
            Entry<K, V> item = buckets[hashKey];
            if (item.getKey() == key) {
                return item.getValue();
            }//may be the item is in the chain
            while (item.next != null) {
                System.out.println("checking " + item.getKey() + " against provided:" + key + " matched: " + (item.getKey() == key));
                if (item.getKey() == key) {
                    return item.getValue();
                }
                item = item.next;
            }
        }
        return null;

    }

    //also write methods for iteration
}

public class CustomHashMapDemo {

    public static void main(String args[]) throws Exception {
        Map map = new HashMap();
        map.remove(map);
        CustomHashMap<String, String> myMap = new CustomHashMap<String, String>();
        myMap.put("a", "val a");
        myMap.put("a", "val second time a");
        myMap.put("b", "val b");
        myMap.put("c", "val c");
        System.out.println(myMap.get("a"));
        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());
        myMap.remove("a");
        System.out.println(myMap.size());
    }

}
