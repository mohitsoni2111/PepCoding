package Binary_Trees;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree {
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
    public static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){         // State -> 1 : left push
            this.node = node;               // State -> 2 : right push
            this.state = state;             // State -> 3 : pop
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
    public static int max(Node node){
        if (node == null) return Integer.MIN_VALUE;

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(Math.max(leftMax, rightMax), node.data);

    }
    public static int height(Node node){
        if (node == null) return -1;        // -1 for edges, 0 for nodes

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void traversal(Node node){
        if (node == null) return;

        System.out.println(node.data);      // Pre Order (Euler left side)
        traversal(node.left);
        System.out.println(node.data);      // In Order (Euler between)
        traversal(node.right);
        System.out.println(node.data);      // Post Order (Euler right side)
    }
    public static void levelOrderTraversal(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);

        while (!mainQueue.isEmpty()){
            int childrenInCurrentLevel = mainQueue.size();
            for (int i = 0; i < childrenInCurrentLevel; i++){
                node = mainQueue.remove();
                System.out.print(node.data + " ");

                if (node.left != null)
                    mainQueue.add(node.left);
                if (node.right != null)
                    mainQueue.add(node.right);
            }
        }
        System.out.println();
    }
    public static void iterativePreInPostTraversal(Node node){
        Stack<Pair> stack = new Stack<>();
        Pair rootPair = new Pair(node, 1);
        stack.push(rootPair);

        String preOrder = "";
        String inOrder = "";
        String postOrder = "";
        while (!stack.isEmpty()){
            Pair top = stack.peek();
            if (top.state == 1){        // pre, state++, left
                preOrder += top.node.data + " ";
                top.state++;

                if (top.node.left != null){
                    Pair leftPair = new Pair(top.node.left, 1);
                    stack.push(leftPair);
                }
            }
            else if (top.state == 2){   // in, state, right
                inOrder += top.node.data + " ";
                top.state++;

                if (top.node.right != null){
                    Pair rightPair = new Pair(top.node.right, 1);
                    stack.push(rightPair);
                }
            }
            else {                      // post, pop
                postOrder += top.node.data + " ";
                stack.pop();
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    static ArrayList<Node> nodeToRootPath;
    public static boolean findElement(Node node, int element){
        if (node == null) return false;
        if (node.data == element) {
            nodeToRootPath.add(node);
            return true;
        }

        boolean findInLeftChild = findElement(node.left, element);
        if (findInLeftChild) {
            nodeToRootPath.add(node);
            return true;
        }

        boolean findInRightChild = findElement(node.right, element);
        if (findInRightChild) {
            nodeToRootPath.add(node);
            return true;
        }
        return false;
    }
    public static void printKLevelDown(Node node, int k, Node blocker){
        if (node == null || k < 0 || node == blocker) return;
        if (k == 0) System.out.println(node.data);

        printKLevelDown(node.left, k - 1, blocker);
        printKLevelDown(node.right, k - 1, blocker);
    }
    public static void printKNodesFar(Node node, int data, int k){
        nodeToRootPath = new ArrayList<>();
        findElement(node, data);
        for (int i = 0; i < nodeToRootPath.size(); i++){
            printKLevelDown(nodeToRootPath.get(i), k - i, i == 0 ? null : nodeToRootPath.get(i - 1));
        }
    }
    public static void rootToLeafPathInRange(Node node, String path, int sum, int low, int high){
        if (node == null) return;
        if (node.left == null && node.right == null){
            sum += node.data;
            if (sum >= low && sum <= high){
                System.out.println(path + node.data);
            }
            return;
        }

        rootToLeafPathInRange(node.left, path + node.data + " ", sum + node.data, low, high);
        rootToLeafPathInRange(node.right, path + node.data + " ", sum + node.data, low, high);
    }
    public static Node createLeftCloneTree(Node node){
        if (node == null) return null;

        Node leftCloned = createLeftCloneTree(node.left);
        Node rightCloned = createLeftCloneTree(node.right);

        node.left = new Node(node.data, leftCloned, null);
        node.right = rightCloned;
        return node;
    }
    public static Node transformBackFromLeftClonedTree(Node node){
        if (node == null) return null;

        Node leftNormalizedNode = transformBackFromLeftClonedTree(node.left.left);
        Node rightNormalizedNode = transformBackFromLeftClonedTree(node.right);

        node.left = leftNormalizedNode;
        node.right = rightNormalizedNode;
        return node;
    }
    public static void printSingleChildNodes(Node node, Node parent){
        if (node == null) return;

        if (parent != null && parent.left == node && parent.right == null){
            System.out.println(node.data);
        }
        else if (parent != null && parent.right == node && parent.left == null){
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }
    public static Node removeLeaves(Node node){
        if (node == null) return null;
        if (node.left == null && node.right == null) return null;

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }
    public static int diameter(@NotNull Node node){
        if (node == null) return 0;

        int leftDia = diameter(node.left);                      // Maximum distance between two nodes both on left side
        int rightDia = diameter(node.right);                    // Maximum distance between two nodes both on right side
        int factor = height(node.left) + height(node.right) + 2;// Maximum dist. b/w left deepest and right deepest

        int dia = Math.max(factor, Math.max(leftDia, rightDia));
        return dia;
    }
    public static class DiaPair{
        int height;
        int dia;
    }
    public static @NotNull DiaPair diameter2(Node node){
        if (node == null){
            DiaPair base = new DiaPair();
            base.height = -1;
            base.dia = 0;
            return base;
        }

        DiaPair leftPair = diameter2(node.left);
        DiaPair rightPair = diameter2(node.right);
        DiaPair myPair = new DiaPair();
        myPair.height = Math.max(leftPair.height, rightPair.height) + 1;

        int factor = leftPair.height + rightPair.height + 2;
        myPair.dia = Math.max(factor, Math.max(leftPair.dia, rightPair.dia));

        return myPair;
    }
    static int tilt = 0;
    public static int tilt(Node node){
        if (node == null) return 0;

        int leftSum = tilt(node.left);
        int rightSum = tilt(node.right);

        int localTilt = Math.abs(leftSum - rightSum);
        tilt += localTilt;

        return leftSum + rightSum + node.data;
    }
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }
    public static @NotNull BSTPair isBST(@NotNull Node node){
        if (node == null){
            BSTPair base = new BSTPair();
            base.isBST = true;
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            return base;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = leftPair.isBST && rightPair.isBST && (node.data >= leftPair.max && node.data <= rightPair.min);
        myPair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        myPair.max = Math.min(node.data, Math.min(leftPair.max, rightPair.max));
        return myPair;
    }
    static boolean isBalanced = true;                               // Travel and change strategies
    public static int isBalanced(Node node){
        if (node == null) return 0;

        int leftHeight = isBalanced(node.left);
        int rightHeight = isBalanced(node.right);

        int gap = Math.abs(leftHeight - rightHeight);
        if (gap > 1) isBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static class BalPair{
        int height;
        boolean isBalanced;
    }                   // return something else, Calculate something else
    public static @NotNull BalPair isBalanced2(Node node){
        if (node == null){
            BalPair base = new BalPair();
            base.isBalanced = true;
            base.height = 0;
            return base;
        }

        BalPair leftPair = isBalanced2(node.left);
        BalPair rightPair = isBalanced2(node.right);
        BalPair myPair = new BalPair();
        myPair.isBalanced = Math.abs(leftPair.height - rightPair.height) <= 1 &&
                leftPair.isBalanced && rightPair.isBalanced;

        myPair.height = Math.max(leftPair.height, rightPair.height) + 1;
        return myPair;
    }
    public static class BSTPair2{
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }
    public static @NotNull BSTPair2 largestBSTSubTree(Node node){
        if (node == null){
            BSTPair2 base = new BSTPair2();
            base.isBST = true;
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.root = null;
            base.size = 1;
            return base;
        }

        BSTPair2 leftPair = largestBSTSubTree(node.left);
        BSTPair2 rightPair = largestBSTSubTree(node.right);

        BSTPair2 myPair = new BSTPair2();
        myPair.isBST = leftPair.isBST && rightPair.isBST &&
                (node.data >= leftPair.max && node.data <= rightPair.min);
        myPair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        myPair.max = Math.min(node.data, Math.min(leftPair.max, rightPair.max));

        if (myPair.isBST){
            myPair.root = node;
            myPair.size = leftPair.size + rightPair.size + 1;
        }
        else if (leftPair.size > rightPair.size){
            myPair.root = leftPair.root;
            myPair.size = leftPair.size;
        }
        else {
            myPair.root = rightPair.root;
            myPair.size = rightPair.size;
        }

        return myPair;
    }



    public static void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);

        int index = 0;
        while (!stack.isEmpty()){
            Pair top = stack.peek();
            if (top.state == 1){
                index++;
                if (arr[index] != null){
                    top.node.left = new Node(arr[index], null, null);
                    Pair leftPair = new Pair(top.node.left, 1);
                    stack.push(leftPair);
                }
                else {
                    top.node.left = null;
                }
                top.state++;
            }
            else if (top.state == 2){
                index++;
                if (arr[index] != null){
                    top.node.right = new Node(arr[index], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    stack.push(rightPair);
                }
                else {
                    top.node.right = null;
                }
                top.state++;
            }
            else {
                stack.pop();
            }
        }
//        nodeToRootPath = new ArrayList<>(); //findElement
//        rootToLeafPathInRange(root, "", 0, 150, 250);
    }
}
