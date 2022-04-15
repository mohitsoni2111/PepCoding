package Binary_Trees;

import java.util.Scanner;

public class width_BT {
    public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int width(TreeNode root, int horizontalLevel, int[] ans){
        if (root == null) return 0;

        ans[0] = Math.min(ans[0], horizontalLevel);
        ans[1] = Math.max(ans[1], horizontalLevel);

        width(root.left, horizontalLevel - 1, ans);
        width(root.right, horizontalLevel + 1, ans);

        return ans[1] - ans[0] + 1;
    }
    public static int width(TreeNode root) {
        int[] ans = new int[2];
        return width(root, 0, ans);
    }

    // input_section=================================================
    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }
    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }
    public static void main(String[] args) {
        solve();
    }
}
