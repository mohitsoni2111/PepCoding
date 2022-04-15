// https://www.youtube.com/watch?v=kCQJTAqbExg&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=62
package Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Bottom_View {
    public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void width(TreeNode node, int horizontalLevel, int[] minMax){
        if (node == null) return;

        minMax[0] = Math.min(minMax[0], horizontalLevel);
        minMax[1] = Math.max(minMax[1], horizontalLevel);

        width(node.left, horizontalLevel - 1, minMax);
        width(node.right, horizontalLevel + 1, minMax);
    }
    public static class vPair{
        TreeNode node;
        int horizontalLevel;
        vPair(TreeNode node, int horizontalLevel){
            this.node = node;
            this.horizontalLevel = horizontalLevel;
        }
    }
    public static ArrayList<Integer> BottomView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        int[] minMax = new int[2];

        width(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        for (int i = 0; i < len; i++)               // Temporary Filling
            ans.add(0);

        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, Math.abs(minMax[0])));

        while (queue.size() > 0){
            int size = queue.size();
            while (size-- > 0) {
                vPair removePair = queue.removeFirst();
                TreeNode node = removePair.node;
                int horizontalLevel = removePair.horizontalLevel;

                ans.set(horizontalLevel, node.val);

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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }
    public static void main(String[] args) {
        solve();
    }
}
