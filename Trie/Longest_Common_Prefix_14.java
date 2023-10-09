package Trie;

import java.util.Arrays;

public class Longest_Common_Prefix_14 {
public String longestCommonPrefix2(String[] v) {
    StringBuilder ans = new StringBuilder();
    Arrays.sort(v);
    String first = v[0];
    String last = v[v.length-1];
    for (int i=0; i<Math.min(first.length(), last.length()); i++) {
        if (first.charAt(i) != last.charAt(i)) {
            return ans.toString();
        }
        ans.append(first.charAt(i));
    }
    return ans.toString();
}

    private StringBuilder prefix = null;
    private int indexes = 0;

    static class TrieNode{
        private boolean isWordEnd;
        private TrieNode[] children = new TrieNode[26];
        public TrieNode(){
            for(int i = 0 ; i < 26; i++){
                children[i] = null;
            }
            isWordEnd = false;
        }
    }

    private void insert(String str, TrieNode root){
        TrieNode current = root;
        int index;

        for(int i = 0; i < str.length(); i++){
            index = str.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWordEnd = true;
    }

    private String findLongestCommonPrefix(int size, TrieNode root){
        TrieNode current = root;
        while(countChildren(current) == 1 && !current.isWordEnd){
            current = current.children[indexes];
            prefix.append((char)('a' + indexes));
        }
        return prefix.toString();
    }

    public int countChildren(TrieNode node){
        int count = 0;
        for (int i = 0; i < 26; i++){
            if(node.children[i] != null){
                count++;
                indexes = i;
            }
        }
        return count;
    }


    TrieNode root;

    public String longestCommonPrefix(String[] stringArray) {
        String longestPrefix = "";
        root = new TrieNode();
        prefix = new StringBuilder();
        for(String str : stringArray){
            insert(str, root);
        }
        return findLongestCommonPrefix(26, root);
    }

}
