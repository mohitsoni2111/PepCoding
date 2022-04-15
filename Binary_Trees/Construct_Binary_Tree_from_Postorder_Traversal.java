package Binary_Trees;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Construct_Binary_Tree_from_Postorder_Traversal {
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

    public static int index = 0;
    private static @Nullable TreeNode buildTree(int[] postOrder, int leftRange, int rightRange){
        if(index < 0 || postOrder[index] < leftRange || postOrder[index] > rightRange) return null;

        TreeNode node = new TreeNode(postOrder[index--]);
        node.right = buildTree(postOrder, node.val, rightRange);
        node.left = buildTree(postOrder, leftRange, node.val);
        return node;
    }

    private static TreeNode buildTree(int @NotNull [] postOrder) {
        int leftRange = -(int)1e9 - 1;
        int rightRange = (int)1e9 + 1;
        return buildTree(postOrder, leftRange, rightRange);
    }

    public static void main(String[] args){
        int[] postOrder = {15,10,23,25,20,35,42,39,30};
        TreeNode obj = buildTree(postOrder);
        display(obj);
    }
}
