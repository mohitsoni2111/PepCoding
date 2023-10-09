package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Implement_Trie_Prefix_tree {

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
    }

    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }

        return this._result;
    }

    private void backtracking(int i, int j, TrieNode root) {
        Character c = this._board[i][j];
        TrieNode current = root.children.get(c);

        // check if there is any match
        if (current.word != null) {
            this._result.add(current.word);
            current.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[i][j] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int k = 0; i < 4; ++i) {
            int newRow = i + rowOffset[k];
            int newCol = j + colOffset[k];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if (current.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, current);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[i][j] = c;

        // Optimization: incrementally remove the leaf nodes
        if (current.children.isEmpty()) {
            root.children.remove(c);
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
