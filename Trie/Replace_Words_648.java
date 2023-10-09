package Trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Replace_Words_648 {
    class TrieNode{
        Map<Character, TrieNode> childrenMap = new HashMap<>();
        String word;
    }
    public void insert(String word, TrieNode root){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!current.childrenMap.containsKey(c)){
                current.childrenMap.put(c, new TrieNode());
            }
            current = current.childrenMap.get(c);
        }
        current.word = word;
    }

    StringBuilder sb = new StringBuilder();
    public void search(String sentence, TrieNode root){
        for (String word: sentence.split("\\s+")){
            if (sb.length() > 0){
                sb.append(" ");
            }

            TrieNode current = root;
            for (Character c : word.toCharArray()){
                if (!current.childrenMap.containsKey(c) || current.word != null){
                    break;
                }
                current = current.childrenMap.get(c);
            }
            sb.append(current.word != null? current.word : word);
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // Insertion
        for (String str : dictionary){
            insert(str, root);
        }

        search(sentence, root);

        return sb.toString();
    }
}
