package LeetCode.BinaryTree;

import Binary_Trees.Binary_Tree;
import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Correct_a_Binary_Tree_1660 {

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
    static Set<Integer> visited = new HashSet<>();
    public static TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null && visited.contains(root.right.val)) {
            return null;
        }
        visited.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);

        return root;
    }

    // BFS
    public TreeNode correctBinaryTree2(TreeNode root) {
        // Queue for BFS. Every element stores [node, parent]
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root, null});

        // Traverse Level by Level
        while (!queue.isEmpty()) {
            // Nodes in the current level
            int n = queue.size();

            // Hash Set to store nodes of the current level
            Set<TreeNode> visited = new HashSet<>();

            // Traverse all nodes in the current level
            for (int i = 0; i < n; i++) {
                // Pop the node and its parent from the queue
                TreeNode[] temp = queue.poll();
                TreeNode node = temp[0], parent = temp[1];

                // If node.right is already visited, then node is defective
                if (visited.contains(node.right)) {
                    // Replace the child of node's parent with null and return root
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return root;
                }

                // Add node to visited
                visited.add(node);

                // Add child in queue for traversal in next level
                // They won't get popped in this level because of "n"
                // Add right child first, so that we can explore right to left
                if (node.right != null) {
                    queue.add(new TreeNode[]{node.right, node});
                }
                if (node.left != null) {
                    queue.add(new TreeNode[]{node.left, node});
                }
            }
        }

        // For the sake of compilation
        return root;
    }
    public static void main(String[] args){
//        root = [8,3,1,7,null,9,4,2,null,null,null,5,6]
        TreeNode six = new TreeNode(6, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, null, null);
        TreeNode four = new TreeNode(4, five, six);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode seven = new TreeNode(7, two, four);
        TreeNode one = new TreeNode(1, nine, four);
        TreeNode three = new TreeNode(3, seven, null);
        TreeNode root = new TreeNode(8, three, one);
        TreeNode res = correctBinaryTree(root);
        display(res);
    }
    public static void display(TreeNode node){
        if (node == null) return;

        String str = "";
        str += node.left == null ? "." : node.left.val + "";
        str += "<-" + node.val + "->";
        str += node.right == null ? "." : node.right.val + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
}
