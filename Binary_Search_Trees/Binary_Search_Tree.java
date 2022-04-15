package Binary_Search_Trees;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Search_Tree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void display(Node node){
        if (node == null) return;

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static @Nullable Node construct(int[] arr, int low, int high){
        if (low > high) return null;

        int mid = low + (high - low) / 2;
        int data = arr[mid];
        Node leftChild = construct(arr, low, mid - 1);
        Node rightChild = construct(arr,mid + 1, high);

        return new Node(data, leftChild, rightChild);
    }
    public static int size(Node node){
        if (node == null) return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }
    public static int sum(Node node){
        if (node == null) return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.data;
    }
    public static int max(@NotNull Node node){
        if (node.right != null)
            return max(node.right);
        else
            return node.data;
    }
    public static int min(@NotNull Node node){
        if (node.left != null)
            return min(node.left);
        else
            return node.data;
    }
    public static int height(Node node){
        if (node == null) return -1;        // -1 for edges, 0 for nodes

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static boolean find(Node node, int element){
        if (node == null) return false;

        if (node.data == element) return true;

        else if (element < node.data)
            return find(node.left, element);
        else
            return find(node.right, element);
    }
    public static Node add(Node node, int element){
        if (node == null){
            return new Node(node.data, null, null);
        }
        if (element > node.data)
            node.right = add(node.right, element);
        else
            node.left = add(node.left, element);

        return node;
    }
    public static Node remove(Node node, int element){
        if (node == null) return null;

        if (element > node.data)
            node.right = remove(node.right, element);
        else if (element < node.data)
            node.left = remove(node.left, element);
        else {
            if (node.left != null && node.right != null){
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);
                return node;
            }
            else if (node.left != null)
                return node.left;
            else if (node.right != null)
                return node.right;
            else
                return null;
        }
        return node;
    }
    static int sum = 0;
    public static void replaceWithSumOfLarger(Node node){
        if (node == null) return;

        replaceWithSumOfLarger(node.right);
        int data = node.data;
        node.data = sum;
        sum += data;
        replaceWithSumOfLarger(node.left);
    }
    public static int lowestCommonAncestor(@NotNull Node node, int data1, int data2){
        if (data1 < node.data && data2 < node.data)
            return lowestCommonAncestor(node.left, data1, data2);
        else if (data1 > node.data && data2 > node.data)
            return lowestCommonAncestor(node.right, data1, data2);
        else
            return node.data;
    }
    public static void printInRange(Node node, int low, int high){
        if (node == null) return;

        if (low < node.data && high < node.data)
            printInRange(node.left, low, high);
        else if (low > node.data && high > node.data)
            printInRange(node.right, low, high);
        else {
            printInRange(node.left, low, high);
            System.out.println(node.data);
            printInRange(node.right, low, high);
        }
    }
    public static void targetSumPair(Node root, Node node, int target){
        if (node == null) return;

        targetSumPair(root, node.left, target);

        int complement = target - node.data;
        if (node.data < complement) {           // Increasing Order
            if (find(root, complement)) {
                System.out.println(node.data + " " + complement);
            }
        }

        targetSumPair(root, node.right, target);
    }
    public static void travelAndFill(Node node, ArrayList<Integer> list){
        if (node == null) return;

        travelAndFill(node.left, list);
        list.add(node.data);
        travelAndFill(node.right, list);
    }
    public static void targetSumPair2(Node node, int target){
        if (node == null) return;

        ArrayList<Integer> list = new ArrayList<>();
        travelAndFill(node, list);

        int i = 0;
        int j = list.size() - 1;
        while (i < j){
            int left = list.get(i);
            int right = list.get(j);
            if (left + right < target) i++;
            else if (left + right > target) j--;
            else {
                System.out.println(left + " " + right);
                i++;
                j--;
            }
        }
    }
    public static class ITPair{
        Node node;
        int state;
        ITPair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static @Nullable Node getNextFromNormalInOrder(@NotNull Stack<ITPair> leftStack){
        while (leftStack.size() > 0){
            ITPair top = leftStack.peek();
            if (top.state == 0) {           // Pre
                if (top.node.left != null)
                    leftStack.push(new ITPair(top.node.left, 0));
                top.state++;
            }
            else if (top.state == 1){       // In
                if (top.node.right != null)
                    leftStack.push(new ITPair(top.node.right, 0));
                top.state++;
                return top.node;
            }
            else {                          // Post
                leftStack.pop();
            }
        }
        return null;
    }
    public static @Nullable Node getNextFromReverseInOrder(@NotNull Stack<ITPair> rightStack){
        while (rightStack.size() > 0){
            ITPair top = rightStack.peek();
            if (top.state == 0) {
                if (top.node.right != null)
                    rightStack.push(new ITPair(top.node.right, 0));
                top.state++;
            }
            else if (top.state == 1){
                if (top.node.left != null)
                    rightStack.push(new ITPair(top.node.left, 0));
                top.state++;
                return top.node;
            }
            else {
                rightStack.pop();
            }
        }
        return null;
    }
    public static void bestApproachTargetSumPair3(Node node, int target){
        Stack<ITPair> leftStack = new Stack<>();
        Stack<ITPair> rightStack = new Stack<>();
        leftStack.push(new ITPair(node, 0));

        Node left = getNextFromNormalInOrder(leftStack);
        Node right = getNextFromReverseInOrder(rightStack);
        while (left.data < right.data){
            if (left.data + right.data < target)
                left = getNextFromNormalInOrder(leftStack);
            else if (left.data + right.data > target)
                right = getNextFromReverseInOrder(rightStack);
            else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInOrder(leftStack);
                right = getNextFromReverseInOrder(rightStack);
            }
        }
    }


    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }
}
