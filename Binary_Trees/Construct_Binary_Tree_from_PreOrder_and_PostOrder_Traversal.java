// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/submissions/

package Binary_Trees;

public class Construct_Binary_Tree_from_PreOrder_and_PostOrder_Traversal {

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

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder, int preSi, int preEi, int postSi, int postEi) {
        if (preSi > preEi) return null;

        TreeNode root = new TreeNode(preorder[preSi]);
        if (preSi == preEi) return root;

        int index = postSi;
        while (postorder[index] != preorder[preSi + 1]) index++;
        int tnel = index - postSi + 1;

        root.left = constructFromPrePost(preorder, postorder, preSi + 1, preSi + tnel, postSi, index);
        root.right = constructFromPrePost(preorder, postorder, preSi + tnel + 1, preEi, index + 1, postEi);;
        return root;
    }
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePost(preorder, postorder,0 ,n - 1, 0, n - 1);
    }

    public static void main(String[] args){
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] postOrder = {4,5,2,6,7,3,1};
        TreeNode obj = constructFromPrePost(preOrder, postOrder);
        display(obj);
    }
}
