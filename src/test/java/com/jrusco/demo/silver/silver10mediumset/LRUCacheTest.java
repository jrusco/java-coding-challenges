package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * https://leetcode.com/problems/lru-cache
 * 
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * == My Notes ==
 * - See commented lines in `LRUCache` class
 */
public class LRUCacheTest {
    
    @Test
    public void test(){
        /**
         * Example 1:
         *
         * Input
         * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         * Output
         * [null, null, null, 1, null, -1, null, -1, 3, 4]
         *
         * Explanation
         * LRUCache lRUCache = new LRUCache(2);
         * lRUCache.put(1, 1); // cache is {1=1}
         * lRUCache.put(2, 2); // cache is {1=1, 2=2}
         * lRUCache.get(1); // return 1
         * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
         * lRUCache.get(2); // returns -1 (not found)
         * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
         * lRUCache.get(1); // return -1 (not found)
         * lRUCache.get(3); // return 3
         * lRUCache.get(4); // return 4
         *
         */
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        assertEquals(1, lRUCache.get(1));
        lRUCache.put(3, 3);
        assertEquals(-1, lRUCache.get(2));
        lRUCache.put(4, 4);
        assertEquals(-1, lRUCache.get(1));
        assertEquals(3, lRUCache.get(3));
        assertEquals(4, lRUCache.get(4));

        // edge case: capacity 1
        LRUCache single = new LRUCache(1);
        single.put(1, 1);
        single.put(2, 2);
        assertEquals(-1, single.get(1));
        assertEquals(2, single.get(2));
    }

    class LRUCache {

        Map<Integer, Integer> cacheStore;

        public LRUCache(int capacity) {
            //Initing LinkedHashMap with accessOrder=true allows LRU behaviour by defaul.
            //This flag causes LRU entries get sorted to the begining of its internal collection.
            //
            //To be able to make use of this LRU behaviour, I need to implement removeEldestEntry(), which is a protected method in the default LinkedHashMap. That's why I'm defining an anonimous class (the most straighforward approach to expose that).
            cacheStore = new LinkedHashMap<Integer, Integer>(capacity, 1f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    //This method automatically gets the eldest, so the only needed logic
                    //here is to return `true` when it should be removed.
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            // Watch out: getOrDefault() does NOT update access order on a hit, only get() does.
            Integer value = cacheStore.get(key);
            return value != null ? value : -1;
        }

        public void put(int key, int value) {
            //LRU eviction is handled automatically by what I defined above after every insertion.
            cacheStore.put(key, value);
        }
    }

    
}
