package Trie;

import java.util.ArrayList;
import java.util.List;

public class Word_Search_II_212 {
    class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        String str;

        // This constructor doesn't matter, by default null
        TrieNode(){
            for (int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public void insert(String word, TrieNode root){
        TrieNode current = root;
        int index = 0;
        for (int i = 0; i < word.length(); i++){
            index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.str = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> ans, boolean[][] visited) {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j]) return;
        TrieNode child = root.children[board[i][j] - 'a'];
        if (child == null) return;
        if (child != null){
            ans.add(child.str);
        }

        visited[i][j] = true;
        dfs(board, i+1, j, child, ans, visited);
        dfs(board, i-1, j, child, ans, visited);
        dfs(board, i, j+1, child, ans, visited);
        dfs(board, i, j-1, child, ans, visited);
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words){
            insert(str, root);
        }

        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, ans, visited);
            }
        }
        return ans;
    }
}
