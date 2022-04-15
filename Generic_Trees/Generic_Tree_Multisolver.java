package Generic_Trees;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Generic_Tree_Multisolver {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
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
    public static Node construct(int @NotNull [] arr){
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
        return root;
    }
    static int size;                                            // In heap memory
    static int min;
    static int max;
    static int height;
    private static void multisolver(@NotNull Node node, int depth){
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        for (Node child : node.children){
            multisolver(child, depth + 1);
        }



    }


    public static void main(String[] args) throws IOException {
        // 24
        // 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(values[i]);

        Node root = construct(arr);
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        multisolver(root, 0);
        System.out.println("size = " + size);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("height = " + height);
    }

}
