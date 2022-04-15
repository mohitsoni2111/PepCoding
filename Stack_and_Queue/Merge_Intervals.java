package Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Merge_Intervals {
    static class Interval {
        int start,end;
        Interval(int start, int end) {
            this.start=start;
            this.end=end;
        }
    }
    private static void mergeIntervals(Interval[] arr) {
        if (arr.length <= 0) return;
        Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);

        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++){
            Interval top = stack.peek();

            // if current interval is not overlapping with stack top, push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);
            else if (top.end < arr[i].end){
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Interval[] arr=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}
