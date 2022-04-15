package Binary_Trees;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Construct_Binary_Tree_from_Inorder_Traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void display(TreeNode node){
        if (node == null) return;

        String str = (node.left == null ? "." : node.left.val + "") +
                "->" + node.val + "<-" +
                (node.right == null ? "." : node.right.val + "");

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    private static @Nullable TreeNode buildTree(int[] inorder, int si, int ei){
        if (si > ei) return null;

        int mid = si + (ei - si) / 2;
        TreeNode node = new TreeNode(inorder[mid]);

        node.left = buildTree(inorder, si, mid - 1);
        node.right = buildTree(inorder, mid + 1, ei);
        return node;
    }
    private static TreeNode buildTree(int @NotNull [] inorder) {
        int n = inorder.length;
        return buildTree(inorder, 0 , n - 1);
    }

    public static void main(String[] args){
        int[] inorder = {9,12,14,17,19,23,50,54,67,72,76};      // Always Sorted
        TreeNode obj = buildTree(inorder);
        display(obj);
    }
}
