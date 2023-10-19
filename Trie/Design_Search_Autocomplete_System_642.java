package Trie;

import java.util.*;

public class Design_Search_Autocomplete_System_642 {

    static class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> sentences;
        public TrieNode() {
            children = new HashMap<>();
            sentences = new HashMap<>();
        }
    }

    static class AutocompleteSystem {
        TrieNode root;
        TrieNode currNode;
        TrieNode dead;
        StringBuilder currSentence;

        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            for (int i = 0; i < sentences.length; i++) {
                addToTrie(sentences[i], times[i]);
            }

            currSentence = new StringBuilder();
            currNode = root;
            dead = new TrieNode();
        }

        public List<String> input(char c) {
            if (c == '#') {
                addToTrie(currSentence.toString(), 1);
                currSentence.setLength(0);
                currNode = root;
                return new ArrayList<String>();
            }

            currSentence.append(c);
            if (!currNode.children.containsKey(c)) {
                currNode = dead;
                return new ArrayList<String>();
            }

            currNode = currNode.children.get(c);
            List<String> sentences = new ArrayList<>(currNode.sentences.keySet());
            sentences.sort((a, b) -> {
                int hotA = currNode.sentences.get(a);
                int hotB = currNode.sentences.get(b);
                if (hotA == hotB) {
                    return a.compareTo(b);
                }

                return hotB - hotA;
            });

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < Math.min(3, sentences.size()); i++) {
                ans.add(sentences.get(i));
            }

            return ans;
        }

        // Min Heap approach, then sort reverse them to get lexicographically
        public List<String> input2(char c) {
            if (c == '#') {
                addToTrie(currSentence.toString(), 1);
                currSentence.setLength(0);
                currNode = root;
                return new ArrayList<String>();
            }

            currSentence.append(c);
            if (!currNode.children.containsKey(c)) {
                currNode = dead;
                return new ArrayList<String>();
            }

            currNode = currNode.children.get(c);
            PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
                int hotA = currNode.sentences.get(a);
                int hotB = currNode.sentences.get(b);
                if (hotA == hotB) {
                    return b.compareTo(a);
                }

                return hotA - hotB;
            });

            for (String sentence: currNode.sentences.keySet()) {
                heap.add(sentence);
                if (heap.size() > 3) {
                    heap.remove();
                }
            }

            List<String> ans = new ArrayList<>();
            while (!heap.isEmpty()) {
                ans.add(heap.remove());
            }

            Collections.reverse(ans);
            return ans;
        }

        private void addToTrie(String sentence, int count) {
            TrieNode current = root;
            for (char c: sentence.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }

                current = current.children.get(c);
                current.sentences.put(sentence, current.sentences.getOrDefault(sentence, 0) + count);
            }
        }
    }
}
