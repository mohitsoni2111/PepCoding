package LeetCode.BinaryTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Validate_Binary_Tree_Nodes_1361 {
    public int findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++){
            set.add(leftChild[i]);
            set.add(rightChild[i]);
        }

        for (int i = 0; i < n; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n ,leftChild, rightChild);
        if (root == -1) return false;

        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        seen.add(root);
        stack.push(root);

        while (!stack.empty()){
            int node = stack.pop();
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children){
                if (child != -1){
                    if (seen.contains(child)){
                        return false;
                    }
                    stack.push(child);
                    seen.add(child);
                }
            }
        }

        return seen.size() == n;
    }
}
