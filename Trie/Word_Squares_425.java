package Trie;

import java.util.*;

public class Word_Squares_425 {

    static class TrieNode{
        Map<Character, TrieNode> children;
        List<Integer> wordList;

        public TrieNode(){
            this.children = new HashMap<>();
            this.wordList = new ArrayList<>();
        }
    } // Map<Character, TrieNode> children, List<Integer> wordList
    int N = 0;
    String[] words = null;
    TrieNode root = null;
    private void buildTrie(String[] words){
        this.root = new TrieNode();

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++){
            TrieNode current = root;

            for (Character c : words[wordIndex].toCharArray()){
                if (!current.children.containsKey(c)){
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
                current.wordList.add(wordIndex);
            }
        }
    }
    private List<Integer> getWordsPrefixWith(String prefix){
        TrieNode current = this.root;

        for (Character c : prefix.toCharArray()){
            if (current.children.containsKey(c)){
                current = current.children.get(c);
            } else {
                // return an empty list
                return new ArrayList<>();
            }
        }
        return current.wordList;
    }
    private void backtracking(int step, LinkedList<String> wordSquares, List<List<String>> results) {
        if (step == N){
            results.add((List<String>) wordSquares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares){
            prefix.append(word.charAt(step));
        }
        for (Integer wordIndex : this.getWordsPrefixWith(prefix.toString())){
            wordSquares.addLast(this.words[wordIndex]);
            this.backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> results = new ArrayList<>();
        this.buildTrie(words);

        for (String word : words){
            LinkedList<String> wordSquares = new LinkedList<>();
            wordSquares.addLast(word);
            this.backtracking(1, wordSquares, results);
        }
        return results;
    }


}
