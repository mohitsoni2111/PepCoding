package LeetCode.BinaryTree;

import java.util.*;

public class Find_Mode_in_Binary_Search_Tree_501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    } // val, left, right
    public static void dfs (TreeNode node, Map<Integer, Integer> counter){
        if (node == null) return;

        counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
        dfs(node.left, counter);
        dfs(node.right, counter);
    } // DFS
    public int[] findMode (TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        dfs(root, counter);
        int maxFreq = 0;

        for (int key : counter.keySet()){
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : counter.keySet()){
            if (counter.get(key) == maxFreq){
                ans.add(key);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }   // DFS
    public int[] findMode2 (TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }


        int maxFreq = 0;
        for (int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }   // Iterative DFS
    public int[] findMode3 (TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int maxFreq = 0;
        for (int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }   // BFS
    public void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        // Inorder traversal visits nodes in sorted order
        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    } // No hashmap
    public int[] findMode4 (TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);

        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList<>();

        for (int num : values) {
            if (num == currNum) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = num;
            }

            if (currStreak > maxStreak) {
                ans = new ArrayList<>();
                maxStreak = currStreak;
            }

            if (currStreak == maxStreak) {
                ans.add(num);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    } // No hashmap
    static class Solution {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList<>();

        public int[] findMode5(TreeNode root) {
            dfs(root);

            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }

            return result;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }

            dfs(node.left);
            int num = node.val;
            if (num == currNum) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = num;
            }

            if (currStreak > maxStreak) {
                ans = new ArrayList<>();
                maxStreak = currStreak;
            }

            if (currStreak == maxStreak) {
                ans.add(num);
            }

            dfs(node.right);
        }
    } //  No "Values" Array

}
