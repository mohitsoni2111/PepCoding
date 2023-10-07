package Trie;

import java.util.HashMap;
import java.util.Map;

public class Implement_Trie_Prefix_tree {

    class Trie {
        class TrieNode {
            public boolean isWord;
            public Map<Character, TrieNode> childrenMap = new HashMap<>();
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (current.childrenMap.get(c) == null){
                    // insert a new Node
                    current.childrenMap.put(c, new TrieNode());
                }
                current = current.childrenMap.get(c);
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (current.childrenMap.get(c) == null){
                    return false;
                }
                current = current.childrenMap.get(c);
            }
            return current.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0;i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(cur.childrenMap.get(c) == null) {
                    return false;
                }
                cur = cur.childrenMap.get(c);
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
