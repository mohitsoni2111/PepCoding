package Trie;

import java.util.HashMap;
import java.util.Map;

public class Design_Add_and_Search_Words_Data_Structure_211 {
    class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> childrenMap;

        public TrieNode(){
            this.childrenMap = new HashMap<>();
        }
    }


    class WordDictionary {
        private TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (current.childrenMap.get(c) == null){
                    current.childrenMap.put(c, new TrieNode());
                }
                current = current.childrenMap.get(c);
            }
            current.isWord = true;
        }

        public boolean search(String word){
            return search(word, root);
        }

        public boolean search(String word, TrieNode root) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!current.childrenMap.containsKey(c)){
                    if (c == '.'){
                        for (char x : current.childrenMap.keySet()){
                            TrieNode child = current.childrenMap.get(x);
                            if (search(word.substring(i + 1), child)){
                                return true;
                            }
                        }
                    }
                    // if no nodes lead to answer
                    // or the current character != '.'
                    return false;

                } else {
                    current = current.childrenMap.get(c);
                }
            }
            return current.isWord;
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
