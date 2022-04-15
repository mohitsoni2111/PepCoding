package Binary_Trees;

import java.util.*;

public class Vertical_Order_Traversal_2 {
    public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void width(TreeNode root, int horizontalLevel, int[] ans){
        if (root == null) return;

        ans[0] = Math.min(ans[0], horizontalLevel);
        ans[1] = Math.max(ans[1], horizontalLevel);

        width(root.left, horizontalLevel - 1, ans);
        width(root.right, horizontalLevel + 1, ans);
    }
    public static class vPair{
        TreeNode node;
        int horizontalLevel;
        vPair(TreeNode node, int horizontalLevel){
            this.node = null;
            this.horizontalLevel = 0;
        }
    }
    public static List<List<Integer>> verticalOrderTraversal_2(TreeNode root) {
        if (root == null)  new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < length; i++)            // Temporary Filling
            ans.add(new ArrayList<>());

        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, Math.abs(minMax[0])));

        while (queue.size() > 0){
            int size = queue.size();
            while (size--> 0){
                vPair removePair = queue.removeFirst();
                TreeNode node = removePair.node;
                int horizontalLevel = removePair.horizontalLevel;

                ans.get(horizontalLevel).add(node.val);

                if (node.left != null)
                    queue.addLast(new vPair(node.left, horizontalLevel - 1));
                if (node.right != null)
                    queue.addLast(new vPair(node.right, horizontalLevel + 1));
            }
        }
        return ans;
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

        List<List<Integer>> ans = verticalOrderTraversal_2(root);
        int idx = 0;
        for (List<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solve();
    }
}
