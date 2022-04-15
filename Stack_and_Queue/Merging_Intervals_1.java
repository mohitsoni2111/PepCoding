package Stack_and_Queue;

import java.util.Arrays;
import java.util.Comparator;

public class Merging_Intervals_1 {
    static class Interval {
        int start,end;
        Interval(int start, int end) {
            this.start=start;
            this.end=end;
        }
    }

    private static void mergeIntervalsWS(Interval[] arr) {
        // Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[index].end >= arr[i].start){        // Merge
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            else {
                index++;
                arr[index] = arr[i];
            }
        }

        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++)
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");

    }

    // Driver Code
    public static void main(String[] args) {
        Interval[] arr=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervalsWS(arr);
    }
}
