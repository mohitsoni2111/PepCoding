package Stack_and_Queue;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Integer minEle;

    public MinStack() {
        stack = new Stack<>();
    }
    public int getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        else return minEle;
    }

    public void push(int val) {
        if (stack.isEmpty()){
            minEle = val;
            stack.push(val);
            return;
        }
        if(val >= minEle) {  // If number is greater than minEle
            stack.push(val);
        }
        else{               // If number is less than minEle
            stack.push(2 * val - minEle);
            minEle = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            System.out.println("Stack underflow");
            return;
        }
        if (stack.peek() < minEle){
            stack.pop();
            minEle = 2 * minEle - stack.peek();
        }
        else
            stack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        if (stack.peek() < minEle)
            return minEle;
        else {
            return stack.peek();
        }
    }
}

public class Minimum_Stack {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        int min = s.getMin();
        System.out.println(min);
        s.push(2);
        s.push(1);
        int min_1 = s.getMin();
        System.out.println(min_1);
        s.pop();
        int min_2 = s.getMin();
        System.out.println(min_2);
        s.pop();
        int top = s.top();
        System.out.println(top);
    }
}
