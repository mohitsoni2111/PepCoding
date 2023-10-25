package Trie;

public class Implement_Trie_II_1804 {
//  Trie trie = new Trie();
//  trie.insert("apple");               // Inserts "apple".
//  trie.insert("apple");               // Inserts another "apple".
//  trie.countWordsEqualTo("apple");    // There are two instances of "apple" so return 2.
//  trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
//  trie.erase("apple");                // Erases one "apple".
//  trie.countWordsEqualTo("apple");    // Now there is only one instance of "apple" so return 1.
//  trie.countWordsStartingWith("app"); // return 1
//  trie.erase("apple");                // Erases "apple". Now the trie is empty.
//  trie.countWordsStartingWith("app"); // return 0
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int wordsEndingHere;
        int wordsStartingHere;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++){
                index = word.charAt(i) - 'a';
                if (current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                current.wordsStartingHere++;
            }
            current.wordsEndingHere++;
        }

        // Returns the number of instances of the string word in the trie.
        public int countWordsEqualTo(String word) {
            TrieNode current = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++){
                index = word.charAt(i) - 'a';
                if (current.children[index] == null){
                    return 0;
                }
                current = current.children[index];
            }
            return current.wordsEndingHere;
        }


        // Returns the number of strings in the trie that have the string prefix as a prefix.
        public int countWordsStartingWith(String prefix) {
            TrieNode current = root;
            int index = 0;
            for (int i = 0; i < prefix.length(); i++){
                index = prefix.charAt(i) - 'a';
                if (current.children[index] == null){
                    return 0;
                }
                current = current.children[index];
            }
            return current.wordsStartingHere;
        }


        // Erases the string word from the trie.
        public void erase(String word) {
            TrieNode current = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++){
                index = word.charAt(i) - 'a';
                if (current.children[index] != null){
                    current = current.children[index];
                    current.wordsStartingHere--;
                }
                current.wordsEndingHere--;
            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
}
