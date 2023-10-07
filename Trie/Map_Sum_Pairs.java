package Trie;
//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/

/*
Design a map that allows you to do the following:

* Maps a string key to a given value.
* Returns the sum of the values that have a key with a prefix equal to a given string.

Implement the `MapSum` class:

* `MapSum()` Initializes the `MapSum` object.
* `void insert(String key, int val)` Inserts the `key-val` pair into the map. If the `key` already existed,
   the original `key-value` pair will be overridden to the new one.
* `int sum(string prefix)` Returns the sum of all the pairs' value whose `key` starts with the `prefix`.
 */

import java.util.HashMap;
import java.util.Map;

public class Map_Sum_Pairs {
    class TrieNode{
        int score;
        Map<Character, TrieNode> childrenMap;

        public TrieNode(){
            this.childrenMap = new HashMap<>();
        }
    }

    class MapSum {
        private TrieNode root;
        private HashMap<String, Integer> map;

        public MapSum() {
            root = new TrieNode();
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode current = root;
            current.score += delta;
            for (char c : key.toCharArray()){
                current.childrenMap.putIfAbsent(c, new TrieNode());
                current = current.childrenMap.get(c);
                current.score += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()){
                current = current.childrenMap.get(c);
                if (current == null) return 0;
            }
            return current.score;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
