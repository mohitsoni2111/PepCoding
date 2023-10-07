package LeetCode.HashMap_HashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Equal_Row_and_Column_Pairs_2352 {

    // Using HashMap
    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }


    // Using Trie

    static class TrieNode{
        int count;
        Map<Integer, TrieNode> children;

        public TrieNode(){
            this.count = 0;
            this.children = new HashMap<>();
        }
    }

    static class Trie{
        TrieNode trie;

        public Trie(){
            this.trie = new TrieNode();
        }

        public void insert(int[] array){
            TrieNode myTrie = this.trie;
            for (int a : array){
                if (!myTrie.children.containsKey(a)){
                    myTrie.children.put(a, new TrieNode());
                }
                myTrie = myTrie.children.get(a);
            }
            myTrie.count += 1;
        }

        public int search(int[] array){
            TrieNode myTrie = this.trie;
            for (int a : array){
                if (myTrie.children.containsKey(a)){
                    myTrie = myTrie.children.get(a);
                } else {
                    return 0;
                }
            }
            return myTrie.count;
        }
    }
    public static int equalPairs2(int[][] grid){
        Trie myTrie = new Trie();
        int count = 0;
        int n = grid.length;

        for (int[] row : grid){
            myTrie.insert(row);
        }
        for (int j = 0; j < n; j++){
            int[] colArray = new int[n];
            for (int i = 0; i < n; i++){
                colArray[i] = grid[i][j];
            }
            count += myTrie.search(colArray);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int result = equalPairs2(matrix);
        System.out.println(result);
    }
}