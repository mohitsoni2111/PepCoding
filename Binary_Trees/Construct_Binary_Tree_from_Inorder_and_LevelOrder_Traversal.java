package Binary_Trees;

import java.util.HashSet;

public class Construct_Binary_Tree_from_Inorder_and_LevelOrder_Traversal {
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


    public static TreeNode buildTree(int[] inOrder, int[] levelOrder, int isi, int iei){
        if (isi > iei) return null;

        TreeNode root = new TreeNode(levelOrder[0]);

        if (levelOrder.length == 1) return root;

        int index = isi;
        while (inOrder[index] != root.val) index++;

        HashSet<Integer> set = new HashSet<>();
        for (int i = isi; i < index; i++) set.add(inOrder[i]);

        int[] levelOrderForLeftSubTree = new int[index - isi];
        int[] levelOrderForRightSubTree = new int[iei - index];
        int ls = 0, rs = 0;

        for (int i = 1; i < levelOrder.length; i++){
            int ele = levelOrder[i];
            if (set.size() != 0 && set.contains(ele)){
                levelOrderForLeftSubTree[ls++] = ele;
                set.remove(ele);
            }
            else {
                levelOrderForRightSubTree[rs++] = ele;
            }
        }

        root.left = buildTree(inOrder, levelOrderForLeftSubTree, isi, index - 1);
        root.right = buildTree(inOrder, levelOrderForRightSubTree, index + 1, iei);
        return root;
    }
    public static TreeNode buildTree(int[] inOrder, int[] levelOrder){
        int n = inOrder.length;
        return buildTree(inOrder, levelOrder, 0, n - 1);
    }

    public static void main(String[] args){
        int[] inOrder = {3,7,5,6,11,2,15,4,9};
        int[] levelOrder = {2,7,15,3,6,9,5,11,4};       // Unique Data
        TreeNode obj = buildTree(inOrder, levelOrder);
        display(obj);
    }
}
