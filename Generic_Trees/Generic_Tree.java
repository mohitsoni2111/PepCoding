package Generic_Trees;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Generic_Tree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(){}
        Node(int data){ this.data = data;}
    }
    public static void display(@NotNull Node node) {
        String str = node.data + " --> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }
    public static int size(@NotNull Node node){
        int size = 0;

        for(Node child : node.children){
            int childSize = size(child);
            size += childSize;
        }
        size += 1;

        return size;
    }
    public static int maximum(@NotNull Node node){
        int max =  Integer.MIN_VALUE;
        for (Node child : node.children){
            int childMax = maximum(child);
            max = Math.max(max, childMax);
        }
        return Math.max(max, node.data);
    }
    public static int height(@NotNull Node node){        // Height by edges
        int height = -1;                        // For edges
//        int height = 0;                          For Nodes height
        for (Node child : node.children){
            int childHeight = maximum(child);
            height = Math.max(height, childHeight);
        }
        height += 1;
        return height;
    }
    public static void traversal(@NotNull Node node){
        System.out.println("Node Pre " + node.data);        // Node pre area
        for (Node child : node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);    // Edge pre area
            traversal(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);    // Edge Post area
        }
        System.out.println("Node Post " + node.data);       // Node post area
    }
    public static void levelOrder(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            node = queue.remove();
            System.out.println(node.data + " ");

            for (Node child : node.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }
    public static void levelOrderLineWise(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();
        mainQueue.add(node);

        while (!mainQueue.isEmpty()){
            node = mainQueue.remove();
            System.out.println(node.data + " ");

            for (Node child : node.children){
                childQueue.add(child);
            }
            if (mainQueue.isEmpty()){
                mainQueue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }       // Two queues
    public static void levelOrderLineWise2(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);
        mainQueue.add(new Node(-1));

        while (!mainQueue.isEmpty()){
            node = mainQueue.remove();
            if (node.data != -1) {
                System.out.println(node.data + " ");

                for (Node child : node.children) {
                    mainQueue.add(child);
                }
            }else{
                if (!mainQueue.isEmpty()){
                    mainQueue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }       // Delimiter(-1)
    public static void levelOrderLineWise3(Node node){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);

        while (!mainQueue.isEmpty()){
           int childrenInCurrentLevel = mainQueue.size();
           for (int i = 0; i < childrenInCurrentLevel; i++){
                node = mainQueue.remove();
                System.out.print(node.data + " ");
                for (Node child : node.children){
                    mainQueue.add(child);
                }
           }
           System.out.println();
        }
    }       // count

    private static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrderLineWise4(Node node){
        Queue<Pair> mainQueue = new ArrayDeque<>();
        mainQueue.add(new Pair(node, 1));
        int level = 1;

        while (!mainQueue.isEmpty()){
            Pair p = mainQueue.remove();
            if (p.level > level){
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for (Node child : p.node.children){
                Pair childPair = new Pair(child, p.level + 1);
                mainQueue.add(childPair);
            }
        }
    }       // Pair Level
    public static void levelOrderLineWiseZZ(Node node){         //  -------->
        Stack<Node> mainStack = new Stack<>();                  //          |
        Stack<Node> childStack = new Stack<>();                 //          |
        int level = 0;                                          //  <--------
        mainStack.push(node);                                   //  |
                                                                //  |
        while (!mainStack.isEmpty()){                           //  -------->
            node = mainStack.pop();
            System.out.println(node.data + " ");

            if (level % 2 == 1){
                for (int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    childStack.push(child);
                }
            }
            else {
                for (int i = node.children.size() - 1; i >= 0; i--){
                    Node child = node.children.get(i);
                    childStack.push(child);
                }
            }
            if (mainStack.isEmpty()){
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
    public static void mirror(@NotNull Node node){
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }
    public static void removeLeaves(@NotNull Node node){
        for (int i = node.children.size() - 1; i >= 0; i++){
            Node child = node.children.get(i);
            if (child.children.size() == 0)
                node.children.remove(child);
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    private static Node getTail(@NotNull Node node) {
        while (node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }
    public static void linearize(@NotNull Node node){
        for (Node child : node.children){
            linearize(child);
        }
        while (node.children.size() > 1){
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLastChild = node.children.get(node.children.size() - 1);
            Node secondLastTail = getTail(secondLastChild);
            secondLastTail.children.add(lastChild);
        }
    }
    public static @NotNull Node linearize2(@NotNull Node node){
        if (node.children.size() == 0)
            return node;

        Node lastTail = linearize2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1){
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = linearize2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;
    }
    public static boolean findElement(@NotNull Node node, int element){
        if (node.data == element) return true;

        for (Node child : node.children){
            boolean findInChild = findElement(child, element);
            if (findInChild){
                return true;
            }
        }
        return false;
    }
    public static @NotNull ArrayList<Integer> nodeToRootPath(@NotNull Node node, int element){
        if (node.data == element){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children){
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, element);
            if (pathTillChild.size() > 0) {
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }
    public static int LowestCommonAncestor(Node node, int data1, int data2){
        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i > 0 && j > 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }
    public static int distanceBetweenNodes(Node node, int data1, int data2){
        ArrayList<Integer> path1 = nodeToRootPath(node, data1);
        ArrayList<Integer> path2 = nodeToRootPath(node, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i > 0 && j > 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    }
    public static boolean areSimilar(@NotNull Node node1, @NotNull Node node2){
        if (node1.children.size() != node2.children.size()) return false;

        for (int i = 0; i < node1.children.size(); i++){
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(i);
            if (!areSimilar(child1, child2)) return false;
        }
        return true;
    }
    public static boolean areMirror(@NotNull Node node1, @NotNull Node node2){
        if (node1.children.size() != node2.children.size()) return false;

        for (int i = 0; i < node1.children.size(); i++){
            int j = node1.children.size() - 1 - i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);
            if (!areMirror(child1, child2)) return false;
        }
        return true;
    }
    public static boolean isSymmetric(Node node){
        return areMirror(node, node);
    }

    // ****************************** Travel and change strategies *********** downwards here on
    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int element){
        if (state == 0){
            if (node.data == element)
                state = 1;
            else
                predecessor = node;
        }
        else if (state == 1){
            successor = node;
            state = 2;
        }
        for (Node child : node.children){
            predecessorAndSuccessor(child, element);
        }
    }
    static int ceil;
    static int floor;
    public static void ceilAndFloor(@NotNull Node node, int element){
        if (node.data > element){
            if (node.data < ceil)
                ceil = node.data;
        }
        if (node.data < element){
            if (node.data > floor)
                floor = node.data;
        }
        for (Node child : node.children){
            ceilAndFloor(child, element);
        }
    }
    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++){
            ceilAndFloor(node, factor);     // floor will be reverted with largest value
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }
    // ******************************** return something else, Calculate something else **************
    static int maximumSumNode = 0;
    static int maximumSum = Integer.MIN_VALUE;
    public static int returnSumAndCalculateMaximumSumSubTree(@NotNull Node node){
        int sum = 0;

        for (Node child : node.children){
            int childSum = returnSumAndCalculateMaximumSumSubTree(child);
            sum += childSum;
        }
        sum += node.data;

        if (sum > maximumSum){
            maximumSumNode = node.data;
            maximumSum = sum;
        }

        return sum;
    }
    static int diameter = 0;
    public static int calculateDiaReturnHeight(@NotNull Node node){
        int deepestChildHeight = -1;
        int secondDeepestChildHeight = -1;

        for (Node child : node.children){
            int childHeight = calculateDiaReturnHeight(child);
            if (childHeight > deepestChildHeight){
                secondDeepestChildHeight = deepestChildHeight;
                deepestChildHeight = childHeight;
            }
            else if (childHeight > secondDeepestChildHeight){
                secondDeepestChildHeight = childHeight;
            }
        }

        int candidate = deepestChildHeight + secondDeepestChildHeight + 2;
        if (candidate > diameter){
            diameter = candidate;
        }
        deepestChildHeight += 1;

        return deepestChildHeight;
    }
    static class Pair2{
        Node node;
        int state;
        Pair2(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void IterativePreAndPostOrder(Node node){
        Stack<Pair2> stack = new Stack<>();
        stack.push(new Pair2(node, -1));
        String preOrder = "";
        String postOrder = "";

        while (!stack.isEmpty()){
            Pair2 top = stack.peek();
            if (top.state == -1){
                preOrder += top.node.data + " ";
                top.state++;
            }
            else if (top.state == top.node.children.size()){
                postOrder += top.node.data + " ";
                stack.pop();
            }
            else {
                Pair2 childPair = new Pair2(top.node.children.get(top.state), -1);
                stack.push(childPair);
                top.state++;
            }
        }
        System.out.println(preOrder);
        System.out.println(postOrder);
    }


    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == -1) stack.pop();
            else {
                Node t = new Node();
                t.data = arr[i];

                if(!stack.isEmpty()) {
                    stack.peek().children.add(t);
                }
                else {
                    root = t;
                }
                stack.push(t);
            }
        }
        display(root);
        System.out.println();

        state = 0;      // predecessorAndSuccessor
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
    }
}
