package Stack_and_Queue;

public class Stack {
    private int top;
    private int maxSize;
    private int[] arr;

    Stack(int maxSize){
        this.top = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        if (top >= maxSize - 1) return false;
        else return true;
    }

    public boolean push(int data){
        if (isFull()){
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            arr[top++] = data;
            return true;
        }
    }

    public boolean isEmpty(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return true;
        }
        else return false;
    }

    public int peek(){
        if (isEmpty()) return Integer.MIN_VALUE;
        else return arr[top];
    }

    public int pop(){
        if (isEmpty()) return Integer.MIN_VALUE;
        else return arr[top--];
    }

    public void display(){
        if (!isEmpty()){
            System.out.println("Stack Elements : ");
            for (int i = top; i >= 0; i--)
                System.out.println(arr[i] + " ");
        }
    }
}
